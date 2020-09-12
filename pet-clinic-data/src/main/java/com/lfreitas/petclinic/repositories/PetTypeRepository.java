package com.lfreitas.petclinic.repositories;

import com.lfreitas.petclinic.model.PetType;
import org.springframework.data.repository.CrudRepository;

public interface PetTypeRepository extends CrudRepository<PetType, Long> {
}
