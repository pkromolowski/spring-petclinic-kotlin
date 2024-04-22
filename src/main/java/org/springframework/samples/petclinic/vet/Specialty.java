

```java
package org.springframework.samples.petclinic.vet;

import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * Models a Vet's specialty (for example, dentistry).
 *
 * @author Juergen Hoeller
 * @author Antoine Rey
 */
@Entity
@Table(name = "specialties")
public class Specialty extends NamedEntity {
    
}
```
