package com.iudigital.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.iudigital.models.User;
import com.iudigital.repositories.UserRepository;

@Service
public class UserServices {
	
	@Autowired
	UserRepository userRepository;
	
	public void CreateUser(User user) {
		
		try {
		userRepository.save(user);
		}catch (Exception e) {
			System.out.println("Ha ocurrido un error");
			// TODO: handle exception
		}
	};
	
	public User GetUser(String id) {
		
		return userRepository.findById(id).get();
	};
	
	public void deleteUser(String id) {
		try {
			userRepository.deleteById(id);		
		}catch (Exception e) {
			System.out.println(e.getMessage());
		};
		
	}
	
	

}
