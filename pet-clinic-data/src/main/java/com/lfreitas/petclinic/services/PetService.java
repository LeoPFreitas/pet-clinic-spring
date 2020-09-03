package com.lfreitas.petclinic.services;


import com.lfreitas.petclinic.module.Pet;

import java.util.Set;

public interface PetService {

    Pet findById(Long id);

    Pet save(Pet pet);

    Set<Pet> findAll();
}
