

```cpp
#include <string>
#include <iostream>

namespace org {
    namespace springframework {
        namespace samples {
            namespace petclinic {
                namespace owner {

                    class PetValidator {
                    public:
                        void validate(void* obj, void* errors) {
                            auto pet = static_cast<Pet*>(obj);
                            auto name = pet->name;
                            
                            // name validation
                            if (name.empty()) {
                                errors->rejectValue("name", REQUIRED, REQUIRED);
                            }

                            // type validation
                            if (pet->isNew && pet->type == nullptr) {
                                errors->rejectValue("type", REQUIRED, REQUIRED);
                            }

                            // birth date validation
                            if (pet->birthDate == nullptr) {
                                errors->rejectValue("birthDate", REQUIRED, REQUIRED);
                            }
                        }

                        bool supports(Class* clazz) {
                            return Pet::class.java.isAssignableFrom(clazz);
                        }

                    private:
                        const std::string REQUIRED = "required";
                    };

                } // owner
            } // petclinic
        } // samples
    } // springframework
} // org
```
