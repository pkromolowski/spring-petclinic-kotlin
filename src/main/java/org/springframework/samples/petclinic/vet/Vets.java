

```java
package org.springframework.samples.petclinic.vet;

import jakarta.xml.bind.annotation.XmlRootElement;
import lombok.Data;

import java.util.Collection;

/**
 * Simple domain object representing a list of veterinarians. Mostly here to be used for the 'vets' [ ].
 *
 * @author Arjen Poutsma
 * @author Antoine Rey
 */
@XmlRootElement
@Data
public class Vets {
    private Collection<Vet> vetList;

    public Vets(Collection<Vet> vetList) {
        this.vetList = vetList;
    }

    public Vets() {
    }
}
```
