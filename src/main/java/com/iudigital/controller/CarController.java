package com.iudigital.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.iudigital.models.Car;
import com.iudigital.services.CarServices;

@RestController
@RequestMapping("/car")
public class CarController {
	@Autowired
	CarServices carServices;
	
	@PostMapping()
	public void CreateCar(@RequestBody Car car) {
		carServices.CreateCar(car);
	};
	
	@GetMapping("{id}")
	public Car getCar(@PathVariable(name="id") int  id) {
		return carServices.GetCar(id);
		
		
	};
	
	@PostMapping("/delete/{id}")
	public void deleteCar(@PathVariable(name="id") int id) {
		carServices.deleteCar(id);
	}
	
	
	
	
	

}
