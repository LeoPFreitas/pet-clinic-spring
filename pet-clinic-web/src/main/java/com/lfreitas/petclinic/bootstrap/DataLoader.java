package com.lfreitas.petclinic.bootstrap;

import com.lfreitas.petclinic.model.Owner;
import com.lfreitas.petclinic.model.Pet;
import com.lfreitas.petclinic.model.PetType;
import com.lfreitas.petclinic.model.Vet;
import com.lfreitas.petclinic.services.OwnerService;
import com.lfreitas.petclinic.services.PetTypeService;
import com.lfreitas.petclinic.services.VetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
public class DataLoader implements CommandLineRunner {

    private final OwnerService ownerService;
    private final VetService vetService;
    private final PetTypeService petTypeService;

    @Autowired
    public DataLoader(OwnerService ownerService, VetService vetService, PetTypeService petTypeService) {
        this.ownerService = ownerService;
        this.vetService = vetService;
        this.petTypeService = petTypeService;
    }

    @Override
    public void run(String... args) throws Exception {

        PetType dog = new PetType();
        dog.setName("Dog");
        PetType savedDogPetType = petTypeService.save(dog);

        PetType cat = new PetType();
        cat.setName("Cat");
        PetType savedCatPetType = petTypeService.save(cat);

        Owner owner1 = new Owner();
        owner1.setFirstName("Leonardo");
        owner1.setLastName("Freitas");
        owner1.setAddress("Rua Rafael de Abreu, 1393");
        owner1.setCity("Sao Paulo");
        owner1.setTelephone("55987654767");

        Pet leoPet = new Pet();
        leoPet.setPetType(savedDogPetType);
        leoPet.setOwner(owner1);
        leoPet.setBirthDate(LocalDate.now());
        leoPet.setName("Jack");
        owner1.getPets().add(leoPet);
        ownerService.save(owner1);

        Owner owner2 = new Owner();
        owner2.setFirstName("Julio");
        owner2.setLastName("Pereira");
        owner2.setAddress("Rua Rafael de Abreu, 1393");
        owner2.setCity("Sao Paulo");
        owner2.setTelephone("55987654767");

        Pet julioPet = new Pet();
        julioPet.setPetType(savedCatPetType);
        julioPet.setOwner(owner2);
        julioPet.setBirthDate(LocalDate.now());
        julioPet.setName("Silver");
        owner2.getPets().add(julioPet);
        ownerService.save(owner2);

        System.out.println("Loaded Owners...");

        Vet vet1 = new Vet();
        vet1.setFirstName("Pietra");
        vet1.setLastName("Santos");
        vetService.save(vet1);

        Vet vet2 = new Vet();
        vet2.setFirstName("Carla");
        vet2.setLastName("Capalti");
        vetService.save(vet2);

        System.out.println("Loaded Vets...");
    }
}
