package com.iudigital.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.iudigital.models.Car;
import com.iudigital.repositories.CarRepository;

@Service
public class CarServices {
	@Autowired
	CarRepository carRepository;
	
	public void CreateCar(Car car) {
		try {
			carRepository.save(car);
			System.out.println("ok");
			
		}catch (Exception e) {
			System.out.println(e.getMessage());
		};
	};
	
	
	public Car GetCar(int id) {
		return carRepository.findById(id).get();
	};
	
	public void deleteCar(int id) {
		Car carr = GetCar(id);
		carRepository.deleteById(id);
	}

}
