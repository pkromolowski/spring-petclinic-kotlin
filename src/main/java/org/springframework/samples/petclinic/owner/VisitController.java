

```cpp
#include <iostream>
#include <map>
#include <vector>

using namespace std;

class VisitRepository {
    // Add VisitRepository implementation here
};

class PetRepository {
    // Add PetRepository implementation here
};

class Pet {
public:
    void addVisit(Visit visit) {
        // Add logic to add visit to pet
    }
};

class Visit {
    // Add Visit class implementation here
};

class VisitController {
private:
    VisitRepository visits;
    PetRepository pets;

public:
    VisitController(VisitRepository visits, PetRepository pets) : visits(visits), pets(pets) {}

    void setAllowedFields(WebDataBinder dataBinder) {
        dataBinder.setDisallowedFields("id");
    }

    Visit loadPetWithVisit(int petId, map<string, any> model) {
        Pet pet = pets.findById(petId);
        model["pet"] = pet;
        Visit visit;
        pet.addVisit(visit);
        return visit;
    }

    string initNewVisitForm(int petId, map<string, any> model) {
        return "pets/createOrUpdateVisitForm";
    }

    string processNewVisitForm(Visit visit, BindingResult result) {
        if (result.hasErrors()) {
            return "pets/createOrUpdateVisitForm";
        } else {
            visits.save(visit);
            return "redirect:/owners/{ownerId}";
        }
    }
};
```
