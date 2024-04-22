

```java
package org.springframework.samples.petclinic.owner;

import org.springframework.format.Formatter;
import org.springframework.stereotype.Component;

import java.text.ParseException;
import java.util.Locale;

@Component
public class PetTypeFormatter implements Formatter<PetType> {

    private final PetRepository pets;

    public PetTypeFormatter(PetRepository pets) {
        this.pets = pets;
    }

    @Override
    public String print(PetType petType, Locale locale) {
        return petType.getName() != null ? petType.getName() : "";
    }

    @Override
    public PetType parse(String text, Locale locale) throws ParseException {
        PetType foundPetType = pets.findPetTypes().stream()
                .filter(petType -> petType.getName().equals(text))
                .findFirst()
                .orElseThrow(() -> new ParseException("type not found: " + text, 0));
        return foundPetType;
    }
}
```
