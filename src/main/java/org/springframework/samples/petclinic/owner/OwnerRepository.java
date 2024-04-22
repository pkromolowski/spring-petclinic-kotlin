

```cpp
/*
 * Repository class for Owner domain objects All method names are compliant with Spring Data naming
 * conventions so this interface can easily be extended for Spring Data See here: http://static.springsource.org/spring-data/jpa/docs/current/reference/html/jpa.repositories.html#jpa.query-methods.query-creation
 *
 * Author: Ken Krebs
 * Author: Juergen Hoeller
 * Author: Sam Brannen
 * Author: Michael Isvy
 * Author: Antoine Rey
 */

#include <vector>
#include <string>

class OwnerRepository {
public:
    virtual std::vector<Owner> findByLastName(std::string lastName) = 0;
    virtual Owner findById(int id) = 0;
    virtual void save(Owner owner) = 0;
};
```
