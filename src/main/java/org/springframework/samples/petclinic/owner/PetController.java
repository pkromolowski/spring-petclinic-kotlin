

```cpp
#include <iostream>
#include <vector>
#include <string>
#include <algorithm>

using namespace std;

class PetType {
    // Add PetType class members here
};

class Pet {
    // Add Pet class members here
};

class Owner {
    // Add Owner class members here
};

class PetRepository {
public:
    vector<PetType> findPetTypes() {
        // Implement findPetTypes method here
    }

    void save(Pet pet) {
        // Implement save method here
    }
};

class OwnerRepository {
public:
    Owner findById(int ownerId) {
        // Implement findById method here
    }
};

class PetValidator {
    // Add PetValidator class members here
};

class PetController {
private:
    const string VIEWS_PETS_CREATE_OR_UPDATE_FORM = "pets/createOrUpdatePetForm";
    PetRepository pets;
    OwnerRepository owners;

public:
    PetController(PetRepository pets, OwnerRepository owners) : pets(pets), owners(owners) {}

    vector<PetType> populatePetTypes() {
        return pets.findPetTypes();
    }

    Owner findOwner(int ownerId) {
        return owners.findById(ownerId);
    }

    void initOwnerBinder(WebDataBinder dataBinder) {
        dataBinder.setDisallowedFields("id");
    }

    void initPetBinder(WebDataBinder dataBinder) {
        dataBinder.validator = PetValidator();
    }

    string initCreationForm(Owner owner, Model model) {
        Pet pet;
        owner.addPet(pet);
        model["pet"] = pet;
        return VIEWS_PETS_CREATE_OR_UPDATE_FORM;
    }

    string processCreationForm(Owner owner, Pet pet, BindingResult result, Model model) {
        if (!pet.name.empty() && pet.isNew && owner.getPet(pet.name, true) != nullptr) {
            result.rejectValue("name", "duplicate", "already exists");
        }
        owner.addPet(pet);
        if (result.hasErrors()) {
            model["pet"] = pet;
            return VIEWS_PETS_CREATE_OR_UPDATE_FORM;
        } else {
            pets.save(pet);
            return "redirect:/owners/{ownerId}";
        }
    }

    string initUpdateForm(int petId, Model model) {
        Pet pet = pets.findById(petId);
        model["pet"] = pet;
        return VIEWS_PETS_CREATE_OR_UPDATE_FORM;
    }

    string processUpdateForm(Pet pet, BindingResult result, Owner owner, Model model) {
        if (result.hasErrors()) {
            pet.owner = owner;
            model["pet"] = pet;
            return VIEWS_PETS_CREATE_OR_UPDATE_FORM;
        } else {
            owner.addPet(pet);
            pets.save(pet);
            return "redirect:/owners/{ownerId}";
        }
    }
};

// Generate later [class_name]
```
