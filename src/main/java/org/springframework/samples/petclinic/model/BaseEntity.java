

```cpp
#include <iostream>

class BaseEntity {
private:
    int id;

public:
    BaseEntity() : id(0) {}

    int getId() const {
        return id;
    }

    void setId(int id) {
        this->id = id;
    }

    bool isNew() const {
        return id == 0;
    }
};

// Generate later [class_name]
```
