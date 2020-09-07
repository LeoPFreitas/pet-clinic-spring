package com.lfreitas.petclinic.bootstrap;

import com.lfreitas.petclinic.model.Owner;
import com.lfreitas.petclinic.model.Vet;
import com.lfreitas.petclinic.services.OwnerService;
import com.lfreitas.petclinic.services.VetService;
import com.lfreitas.petclinic.services.map.OwnerServiceMap;
import com.lfreitas.petclinic.services.map.VetServiceMap;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements CommandLineRunner {

    private final OwnerService ownerService;
    private final VetService vetService;

    public DataLoader() {
        ownerService = new OwnerServiceMap();
        vetService = new VetServiceMap();
    }

    @Override
    public void run(String... args) throws Exception {
        Owner owner1 = new Owner();
        owner1.setId(1L);
        owner1.setFirstName("Leonardo");
        owner1.setLastName("Freitas");
        ownerService.save(owner1);

        Owner owner2 = new Owner();
        owner2.setId(2L);
        owner2.setFirstName("Julio");
        owner2.setLastName("Pereira");
        ownerService.save(owner2);

        System.out.println("Loaded Owners...");

        Vet vet1 = new Vet();
        vet1.setId(1L);
        vet1.setFirstName("Pietra");
        vet1.setLastName("Santos");
        vetService.save(vet1);

        Vet vet2 = new Vet();
        vet2.setId(2L);
        vet2.setFirstName("Carla");
        vet2.setLastName("Capalti");
        vetService.save(vet2);

        System.out.println("Loaded Vets...");
    }
}