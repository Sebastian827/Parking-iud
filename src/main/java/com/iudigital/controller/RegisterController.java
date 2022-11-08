package com.iudigital.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.iudigital.models.Car;
import com.iudigital.models.Register;
import com.iudigital.services.RegisterServices;
import com.iudigital.services.UserServices;

@RestController
@RequestMapping("/register")
public class RegisterController {
	
	@Autowired
	RegisterServices registerServ;
	
	@PostMapping()
	public void CreateRegister(@RequestBody Register reg) {
		registerServ.createRegister(reg);;
	};
	
	@GetMapping("{id}")
	public ArrayList<Register> getRegisters() {
		return registerServ.getAllRegister();
		
		
	};
	
	@PostMapping("/{id}")
	public void updateRegister(@PathVariable int id) {
		registerServ.putRegister(id);
	}
	
	@GetMapping("/value/{id}")
	public double getValue(@PathVariable(name="id") int id) {
		Register ref = registerServ.getRegister(id);
		
		return ref.getPrice();
		
	}

}
