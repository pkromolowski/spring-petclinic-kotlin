

```cpp
#include <iostream>
#include <vector>
#include <map>
#include <string>

class OwnerRepository {
    // Implement OwnerRepository class here
};

class VisitRepository {
    // Implement VisitRepository class here
};

class Owner {
public:
    int id;
    std::string lastName;
    
    std::vector<Pet> getPets() {
        // Implement getPets method here
    }
};

class Pet {
public:
    int id;
    std::vector<Visit> visits;
};

class Visit {
public:
    int id;
};

class OwnerController {
private:
    OwnerRepository owners;
    VisitRepository visits;
    const std::string VIEWS_OWNER_CREATE_OR_UPDATE_FORM = "owners/createOrUpdateOwnerForm";

public:
    OwnerController(OwnerRepository owners, VisitRepository visits) : owners(owners), visits(visits) {}

    void setAllowedFields() {
        // Implement setAllowedFields method here
    }

    std::string initCreationForm(std::map<std::string, std::any>& model) {
        Owner owner;
        model["owner"] = owner;
        return VIEWS_OWNER_CREATE_OR_UPDATE_FORM;
    }

    std::string processCreationForm(Owner owner, bool result) {
        if (result) {
            owners.save(owner);
            return "redirect:/owners/" + std::to_string(owner.id);
        } else {
            return VIEWS_OWNER_CREATE_OR_UPDATE_FORM;
        }
    }

    std::string initFindForm(std::map<std::string, std::any>& model) {
        model["owner"] = Owner();
        return "owners/findOwners";
    }

    std::string processFindForm(Owner owner, bool result, std::map<std::string, std::any>& model) {
        // find owners by last name
        auto results = owners.findByLastName(owner.lastName);
        switch (results.size()) {
            case 0:
                result.rejectValue("lastName", "notFound", "not found");
                return "owners/findOwners";
            case 1:
                return "redirect:/owners/" + std::to_string(results[0].id);
            default:
                model["selections"] = results;
                return "owners/ownersList";
        }
    }

    std::string initUpdateOwnerForm(int ownerId, Model model) {
        Owner owner = owners.findById(ownerId);
        model.addAttribute(owner);
        return VIEWS_OWNER_CREATE_OR_UPDATE_FORM;
    }

    std::string processUpdateOwnerForm(Owner owner, bool result, int ownerId) {
        if (result) {
            owner.id = ownerId;
            this.owners.save(owner);
            return "redirect:/owners/" + std::to_string(ownerId);
        } else {
            return VIEWS_OWNER_CREATE_OR_UPDATE_FORM;
        }
    }

    std::string showOwner(int ownerId, Model model) {
        Owner owner = this.owners.findById(ownerId);
        for (Pet pet : owner.getPets()) {
            pet.visits = visits.findByPetId(pet.id);
        }
        model.addAttribute(owner);
        return "owners/ownerDetails";
    }
};
```
