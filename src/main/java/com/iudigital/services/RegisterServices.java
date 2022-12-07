package com.iudigital.services;

import java.time.LocalDateTime;
import java.time.chrono.ChronoLocalDateTime;
import java.util.Collection;
import java.util.Collections;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.iudigital.models.ReceiptPayment;
import com.iudigital.models.Register;
import com.iudigital.repositories.ReceiptPaymentRepository;
import com.iudigital.repositories.RegisterRepository;
import java.time.temporal.ChronoUnit;
@Service
public class RegisterServices {
	
	@Autowired
	RegisterRepository registerRepo;
	
	@Autowired
	ReceiptPaymentRepository rePayment;
	
	public void createRegister(Register reg) {
		reg.setCheckIn(LocalDateTime.now());
		registerRepo.save(reg);
	}
	
	public void putRegister(int id) {
		Register reg = registerRepo.findById(id).get();
		reg.setCheckOut(LocalDateTime.now());
		
		
		LocalDateTime a=reg.getCheckIn();
		LocalDateTime b= reg.getCheckOut();
		double n = ChronoUnit.SECONDS.between(a, b);
		double l = Math.ceil(n /3600);
		Long time =(long) Math.ceil(l);
		
		reg.setPrice(time*5000 );
		reg.setState(false);
		registerRepo.save(reg);
		
		ReceiptPayment rp = new ReceiptPayment();
		int i = (int) Math.ceil(l);
		rp.setUserName(reg.getCar().getUser().getName());
		rp.setPlates(reg.getCar().getPlate());
		rp.setValue(reg.getPrice());
		rp.setCheckIn(reg.getCheckIn());
		rp.setCheckOut(reg.getCheckOut());
		rp.setHours(i);
		rp.setRegisterId(reg.getIdregister());
		rp.setCell(reg.getCell());
		
		rePayment.save(rp);
		
	}
	
	public ArrayList<Register> getAllRegister(){
		return  (ArrayList<Register>) registerRepo.findAll();
	}
	
	
	public ArrayList<Register> getActiveRegister(){
		
		ArrayList<Register> r =(ArrayList<Register>) registerRepo.findAll();
		
		ArrayList<Register> m = new ArrayList<>();
		for(Register i:r) {
			if(i.isState()) {
				m.add(i);
			}
		}
		
		Collections.sort(m,(a,b) -> Integer.valueOf(a.getCell()).compareTo(Integer.valueOf(b.getCell())));

		
		return m;
		
	}
	
	public Register getRegister(int id) {
		return registerRepo.findById(id).get();
	}

}
