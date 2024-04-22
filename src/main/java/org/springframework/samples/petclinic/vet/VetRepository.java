

```java
package org.springframework.samples.petclinic.vet;

import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.repository.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collection;

/**
 * Repository class for Vet domain objects All method names are compliant with Spring Data naming
 * conventions so this interface can easily be extended for Spring Data See here: http://static.springsource.org/spring-data/jpa/docs/current/reference/html/jpa.repositories.html#jpa.query-methods.query-creation
 *
 * @author Ken Krebs
 * @author Juergen Hoeller
 * @author Sam Brannen
 * @author Michael Isvy
 * @author Antoine Rey
 */
public interface VetRepository extends Repository<Vet, Integer> {

    /**
     * Retrieve all Vets from the data store.
     *
     * @return a Collection of Vets
     */
    @Transactional(readOnly = true)
    @Cacheable("vets")
    Collection<Vet> findAll();

}
```
