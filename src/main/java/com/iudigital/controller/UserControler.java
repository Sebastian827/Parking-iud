package com.iudigital.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.iudigital.models.Car;
import com.iudigital.models.User;
import com.iudigital.services.CarServices;
import com.iudigital.services.UserServices;

@RestController
@RequestMapping("/user")
public class UserControler {
	@Autowired
	UserServices userServices;
	
	@PostMapping()
	public void CreateUser(@RequestBody User user) {
		userServices.CreateUser(user);
	};
	
	@GetMapping("{id}")
	public User getUser(@PathVariable(name="id") String  id) {
		
		return userServices.GetUser(id);
	};
	
	@PostMapping("/delete/{id}")
	public void deleteUser(@PathVariable(name="id") String id) {
		userServices.deleteUser(id);
	}
	

}
