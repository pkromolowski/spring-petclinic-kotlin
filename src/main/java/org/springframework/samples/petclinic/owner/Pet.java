

```java
package org.springframework.samples.petclinic.owner;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.samples.petclinic.model.NamedEntity;
import org.springframework.samples.petclinic.visit.Visit;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

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
        return visits.stream()
                .sorted((v1, v2) -> v1.getDate().compareTo(v2.getDate()))
                .toList();
    }

    public void addVisit(Visit visit) {
        visits.add(visit);
        visit.setPetId(this.getId());
    }
}
```
