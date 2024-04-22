

```cpp
#include <iostream>
#include <string>
#include <vector>

// Generate later PetRepository

class PetType {
public:
    std::string name;
};

// Generate later PetRepository

class PetTypeFormatter {
private:
    PetRepository pets;

public:
    PetTypeFormatter(PetRepository pets) : pets(pets) {}

    std::string print(PetType petType, std::string locale) {
        return petType.name;
    }

    PetType parse(std::string text, std::string locale) {
        auto findPetTypes = this->pets.findPetTypes();
        for (const auto& petType : findPetTypes) {
            if (petType.name == text) {
                return petType;
            }
        }
        throw std::invalid_argument("type not found: " + text);
    }
};

int main() {
    // Main method for testing the PetTypeFormatter class
    PetRepository pets; // Instantiate PetRepository
    PetTypeFormatter formatter(pets); // Instantiate PetTypeFormatter

    PetType petType;
    petType.name = "Dog";

    std::string printed = formatter.print(petType, "en_US");
    std::cout << "Printed: " << printed << std::endl;

    PetType parsed = formatter.parse("Cat", "en_US");
    std::cout << "Parsed: " << parsed.name << std::endl;

    return 0;
}
```
