package com.lfreitas.petclinic.services;

import com.lfreitas.petclinic.module.Vet;

import java.util.Set;

public interface VetService {

    Vet findById(Long id);

    Vet save(Vet vet);

    Set<Vet> findAll();
}
