package com.iudigital.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.iudigital.models.Register;

@Repository
public interface RegisterRepository extends CrudRepository<Register, Integer> {

}
