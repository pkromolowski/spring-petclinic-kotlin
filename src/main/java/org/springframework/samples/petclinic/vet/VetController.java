

```java
package org.springframework.samples.petclinic.vet;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Map;

@Controller
public class VetController {

    private final VetRepository vetRepository;

    public VetController(VetRepository vetRepository) {
        this.vetRepository = vetRepository;
    }

    @GetMapping("/vets.html")
    public String showHtmlVetList(Map<String, Object> model) {
        Vets vets = new Vets(vetRepository.findAll());
        model.put("vets", vets);
        return "vets/vetList";
    }

    @GetMapping(value = "vets.json", produces = "application/json")
    @ResponseBody
    public Vets showJsonVetList() {
        return new Vets(vetRepository.findAll());
    }

    @GetMapping("vets.xml")
    @ResponseBody
    public Vets showXmlVetList() {
        return new Vets(vetRepository.findAll());
    }
}
```
