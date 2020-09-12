package com.lfreitas.petclinic.repositories;

import com.lfreitas.petclinic.model.Vet;
import org.springframework.data.repository.CrudRepository;

public interface VetRepository extends CrudRepository<Vet, Long> {
}
