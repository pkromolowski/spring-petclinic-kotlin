

```cpp
#include <iostream>
#include <string>
#include <vector>
#include <algorithm>
#include <chrono>
#include <unordered_set>

class NamedEntity {
public:
    std::string name;
    int id;
};

class PetType : public NamedEntity {
};

class Owner;

class Visit {
public:
    std::chrono::system_clock::time_point date;
    int petId;
};

class Pet : public NamedEntity {
public:
    std::chrono::system_clock::time_point birthDate;
    PetType* type;
    Owner* owner;
    std::unordered_set<Visit> visits;

    std::vector<Visit> getVisits() {
        std::vector<Visit> sortedVisits(visits.begin(), visits.end());
        std::sort(sortedVisits.begin(), sortedVisits.end(), [](const Visit& a, const Visit& b) {
            return a.date < b.date;
        });
        return sortedVisits;
    }

    void addVisit(const Visit& visit) {
        visits.insert(visit);
        visit.petId = this->id;
    }
};
```
