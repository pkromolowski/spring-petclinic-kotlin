

```cpp
#include <iostream>
#include <map>
#include <string>
#include <vector>

// Generate later VetRepository

class Vet {
public:
    // Generate later VetRepository
};

class Vets {
public:
    Vets(std::vector<Vet> vets) : vets(vets) {}

private:
    std::vector<Vet> vets;
};

class VetController {
public:
    VetController(/* Generate later VetRepository */ VetRepository) : vetRepository(vetRepository) {}

    std::string showHtmlVetList(std::map<std::string, std::any>& model) {
        Vets vets(/* Generate later VetRepository */ vetRepository.findAll());
        model["vets"] = vets;
        return "vets/vetList";
    }

    Vets showJsonVetList() {
        return Vets(/* Generate later VetRepository */ vetRepository.findAll());
    }

    Vets showXmlVetList() {
        return Vets(/* Generate later VetRepository */ vetRepository.findAll());
    }

private:
    // Generate later VetRepository
};

```
