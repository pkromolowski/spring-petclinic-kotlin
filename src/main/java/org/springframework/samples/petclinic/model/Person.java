

```cpp
#include <string>

class Person : public BaseEntity {
private:
    std::string firstName = "";
    std::string lastName = "";

public:
    std::string getFirstName() {
        return firstName;
    }

    void setFirstName(std::string firstName) {
        this->firstName = firstName;
    }

    std::string getLastName() {
        return lastName;
    }

    void setLastName(std::string lastName) {
        this->lastName = lastName;
    }
};
```
