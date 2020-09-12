package com.lfreitas.petclinic.repositories;

import com.lfreitas.petclinic.model.Pet;
import org.springframework.data.repository.CrudRepository;

public interface PetRepository extends CrudRepository<Pet, Long> {
}
