package com.lfreitas.petclinic.repositories;

import com.lfreitas.petclinic.model.Visit;
import org.springframework.data.repository.CrudRepository;

public interface VisitRepository extends CrudRepository<Visit, Long> {
}
