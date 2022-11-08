package com.iudigital.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.iudigital.models.Car;

@Repository
public interface CarRepository extends CrudRepository<Car, Integer> {

}
