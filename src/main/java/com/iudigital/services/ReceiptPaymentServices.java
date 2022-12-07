package com.iudigital.services;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.iudigital.models.ReceiptPayment;
import com.iudigital.models.Register;
import com.iudigital.repositories.ReceiptPaymentRepository;

@Service
public class ReceiptPaymentServices {
	
	@Autowired
	ReceiptPaymentRepository rePayment;
	
	@Autowired
	RegisterServices regSer;
	
	
	public ArrayList<ReceiptPayment> GetPayment(String id) {
		ArrayList<ReceiptPayment> arr = getAllPayment();
		
		ArrayList<ReceiptPayment> ar2 = new ArrayList<>();
		for(ReceiptPayment i: arr) {
			Register reg = regSer.getRegister(i.getRegisterId());
			
			if(reg.getCar().getUser().getCedula().equals(id)) {
				ar2.add(i);
			}
			
			
		}
		return ar2;
	};
	
	public ArrayList<ReceiptPayment> getAllPayment(){
		return (ArrayList<ReceiptPayment>) rePayment.findAll();
	}

}
