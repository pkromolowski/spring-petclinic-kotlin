

```cpp
#include <iostream>
#include <vector>
#include <algorithm>

class Owner : public Person {
private:
    std::string address = "";
    std::string city = "";
    std::string telephone = "";
    std::vector<Pet> pets;

public:
    std::vector<Pet> getPets() {
        std::sort(pets.begin(), pets.end(), [](const Pet& a, const Pet& b) {
            return a.getName() < b.getName();
        });
        return pets;
    }

    void addPet(Pet pet) {
        if (pet.isNew()) {
            pets.push_back(pet);
        }
        pet.setOwner(this);
    }

    Pet* getPet(std::string name) {
        return getPet(name, false);
    }

    Pet* getPet(std::string name, bool ignoreNew) {
        std::transform(name.begin(), name.end(), name.begin(), ::tolower);
        for (Pet& pet : pets) {
            if (!ignoreNew || !pet.isNew()) {
                std::string compName = pet.getName();
                std::transform(compName.begin(), compName.end(), compName.begin(), ::tolower);
                if (compName == name) {
                    return &pet;
                }
            }
        }
        return nullptr;
    }
};

// Generate later Person
// Generate later Pet
```
