

```cpp
#include <iostream>
#include <vector>
#include <algorithm>

class Vet : public Person {
private:
    std::vector<Specialty> specialties;

public:
    std::vector<Specialty> getSpecialties() {
        std::sort(specialties.begin(), specialties.end(), [](const Specialty& a, const Specialty& b) {
            return a.getName() < b.getName();
        });
        return specialties;
    }

    int getNrOfSpecialties() {
        return specialties.size();
    }

    void addSpecialty(const Specialty& specialty) {
        specialties.push_back(specialty);
    }
};
```
