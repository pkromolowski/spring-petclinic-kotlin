

```java
package org.springframework.samples.petclinic.owner;

import org.springframework.samples.petclinic.model.Person;

import javax.persistence.*;
import javax.validation.constraints.Digits;
import javax.validation.constraints.NotEmpty;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "owners")
public class Owner extends Person {
    @Column(name = "address")
    @NotEmpty
    private String address = "";

    @Column(name = "city")
    @NotEmpty
    private String city = "";

    @Column(name = "telephone")
    @NotEmpty
    @Digits(fraction = 0, integer = 10)
    private String telephone = "";

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "owner")
    private Set<Pet> pets = new HashSet<>();

    public List<Pet> getPets() {
        return pets.stream()
                .sorted(Comparator.comparing(Pet::getName))
                .collect(Collectors.toList());
    }

    public void addPet(Pet pet) {
        if (pet.isNew()) {
            pets.add(pet);
        }
        pet.setOwner(this);
    }

    public Pet getPet(String name) {
        return getPet(name, false);
    }

    public Pet getPet(String name, boolean ignoreNew) {
        String lowerName = name.toLowerCase();
        for (Pet pet : pets) {
            if (!ignoreNew || !pet.isNew()) {
                String petName = pet.getName() != null ? pet.getName().toLowerCase() : null;
                if (petName != null && petName.equals(lowerName)) {
                    return pet;
                }
            }
        }
        return null;
    }
}
```
