

```java
package org.springframework.samples.petclinic.owner;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collection;

/**
 * Repository class for Owner domain objects All method names are compliant with Spring Data naming
 * conventions so this interface can easily be extended for Spring Data See here: http://static.springsource.org/spring-data/jpa/docs/current/reference/html/jpa.repositories.html#jpa.query-methods.query-creation
 *
 * @author Ken Krebs
 * @author Juergen Hoeller
 * @author Sam Brannen
 * @author Michael Isvy
 * @author Antoine Rey
 */
public interface OwnerRepository extends Repository<Owner, Integer> {

    /**
     * Retrieve Owners from the data store by last name, returning all owners
     * whose last name starts with the given name.
     * @param lastName Value to search for
     * @return a Collection of matching Owners (or an empty Collection if none found)
     */
    @Query("SELECT DISTINCT owner FROM Owner owner left join fetch owner.pets WHERE owner.lastName LIKE :lastName%")
    @Transactional(readOnly = true)
    Collection<Owner> findByLastName(String lastName);

    /**
     * Retrieve an Owner from the data store by id.
     * @param id the id to search for
     * @return the Owner if found
     */
    @Query("SELECT owner FROM Owner owner left join fetch owner.pets WHERE owner.id = :id")
    @Transactional(readOnly = true)
    Owner findById(Integer id);

    /**
     * Save an Owner to the data store, either inserting or updating it.
     * @param owner the Owner to save
     */
    void save(Owner owner);
}
```
