

```cpp
#include <iostream>
#include <string>
#include <chrono>

using namespace std;

class Visit {
private:
    chrono::system_clock::time_point date = chrono::system_clock::now();
    string description;
    int petId;

public:
    chrono::system_clock::time_point getDate() {
        return date;
    }

    void setDate(chrono::system_clock::time_point newDate) {
        date = newDate;
    }

    string getDescription() {
        return description;
    }

    void setDescription(string newDescription) {
        description = newDescription;
    }

    int getPetId() {
        return petId;
    }

    void setPetId(int newPetId) {
        petId = newPetId;
    }
};
```
