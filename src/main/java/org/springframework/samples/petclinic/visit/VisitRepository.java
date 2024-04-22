package org.springframework.samples.petclinic.visit;

import org.springframework.data.repository.Repository;
import org.springframework.samples.petclinic.model.BaseEntity;

import java.util.Set;

/**
 * Repository class for `Visit` domain objects All method names are compliant with Spring Data naming
 * conventions so this interface can easily be extended for Spring Data See here: http://static.springsource.org/spring-data/jpa/docs/current/reference/html/jpa.repositories.html#jpa.query-methods.query-creation
 *
 * @author Ken Krebs
 * @author Juergen Hoeller
 * @author Sam Brannen
 * @author Michael Isvy
 * @author Antoine Rey
 */
public interface VisitRepository extends Repository<Visit, Integer> {

    /**
     * Save a `Visit` to the data store, either inserting or updating it.
     *
     * @param visit the `Visit` to save
     * @see BaseEntity.isNew
     */
    void save(Visit visit);

    Set<Visit> findByPetId(Integer petId);

}