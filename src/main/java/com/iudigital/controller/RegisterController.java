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
	int numCell=4;
	@Autowired
	RegisterServices registerServ;
	
	@PostMapping()
	public String CreateRegister(@RequestBody Register reg) {
		
		if(registerServ.getActiveRegister().size()>numCell) {
			return "No hay celdas disponibles";
		}
		setCell(reg);
		registerServ.createRegister(reg);;
		return String.valueOf(registerServ.getActiveRegister().size());
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
	
	public void setCell(Register reg) {
		int n =registerServ.getActiveRegister().size();	
		for(int i=0;i<n;i++) {
			if(registerServ.getActiveRegister().get(i).getCell()!=(i+1)) {			
				reg.setCell(i+1);
				
			}
		}
		
	}
	@GetMapping("/active")
	public ArrayList<Register> getActiveRegister() {
		return registerServ.getActiveRegister();
		
	}

	
}
