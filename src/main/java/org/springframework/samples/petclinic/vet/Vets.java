

```java
package org.springframework.samples.petclinic.vet;

import jakarta.xml.bind.annotation.XmlRootElement;
import java.util.Collection;

@XmlRootElement
public class Vets {
    private Collection<Vet> vetList;

    public Vets(Collection<Vet> vetList) {
        this.vetList = vetList;
    }

    public Collection<Vet> getVetList() {
        return vetList;
    }

    public void setVetList(Collection<Vet> vetList) {
        this.vetList = vetList;
    }
}
```
