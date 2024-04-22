package org.springframework.samples.petclinic.vet;

import org.springframework.samples.petclinic.model.Person;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlElement;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Entity
@Table(name = "vets")
public class Vet extends Person {

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "vet_specialties", joinColumns = @JoinColumn(name = "vet_id"), inverseJoinColumns = @JoinColumn(name = "specialty_id"))
    private Set<Specialty> specialties = new HashSet<>();

    @XmlElement
    public List<Specialty> getSpecialties() {
        return specialties.stream()
                .sorted((s1, s2) -> s1.getName().compareTo(s2.getName()))
                .collect(Collectors.toList());
    }

    public int getNrOfSpecialties() {
        return specialties.size();
    }

    public void addSpecialty(Specialty specialty) {
        specialties.add(specialty);
    }
}