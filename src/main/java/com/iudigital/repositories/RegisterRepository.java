package com.iudigital.repositories;

import java.util.ArrayList;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.iudigital.models.Register;

@Repository
public interface RegisterRepository extends CrudRepository<Register, Integer> {
	
}
