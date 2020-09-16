package com.lfreitas.petclinic.services;

import com.lfreitas.petclinic.model.Owner;

public interface OwnerService extends CrudService<Owner, Long> {

    Owner findByLastName(String lastName);

}
