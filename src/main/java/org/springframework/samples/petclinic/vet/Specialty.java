

// Generate later Specialty

#include <string>

class Specialty {
private:
    std::string name;

public:
    Specialty(std::string name) : name(name) {}

    std::string getName() {
        return name;
    }

    void setName(std::string name) {
        this->name = name;
    }
};
