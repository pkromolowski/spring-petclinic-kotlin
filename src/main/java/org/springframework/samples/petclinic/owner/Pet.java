

```java
package org.springframework.samples.petclinic.owner;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.samples.petclinic.model.NamedEntity;
import org.springframework.samples.petclinic.visit.Visit;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.*;

@Entity
@Table(name = "pets")
public class Pet extends NamedEntity {

    @Column(name = "birth_date")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate birthDate;

    @ManyToOne
    @JoinColumn(name = "type_id")
    private PetType type;

    @ManyToOne
    @JoinColumn(name = "owner_id")
    private Owner owner;

    @Transient
    private Set<Visit> visits = new LinkedHashSet<>();

    public List<Visit> getVisits() {
        List<Visit> sortedVisits = new ArrayList<>(visits);
        sortedVisits.sort(Comparator.comparing(Visit::getDate));
        return sortedVisits;
    }

    public void addVisit(Visit visit) {
        visits.add(visit);
        visit.setPetId(this.getId());
    }
}
```
