package org.springframework.samples.petclinic;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.SpringApplication;

/**
 * PetClinic Spring Boot Application.
 *
 * @author Dave Syer
 * @author Antoine Rey
 */
@SpringBootApplication(proxyBeanMethods = false)
public class PetClinicApplication {

    public static void main(String[] args) {
        SpringApplication.run(PetClinicApplication.class, args);
    }
}