

```cpp
#include <string>

class NamedEntity : public BaseEntity {
private:
    std::string name;

public:
    NamedEntity() = default;

    std::string getName() const {
        return name;
    }

    void setName(const std::string& name) {
        this->name = name;
    }

    std::string toString() const {
        return name.empty() ? "" : name;
    }
};
```
