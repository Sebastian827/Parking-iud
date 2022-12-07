package com.iudigital.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.iudigital.models.ReceiptPayment;
import com.iudigital.services.ReceiptPaymentServices;

@RestController
@RequestMapping("/payment")
public class ReceiptPaymentController {
	
	@Autowired
	ReceiptPaymentServices paymentService;
	
	
	@GetMapping("{id}")
	public ArrayList<ReceiptPayment> getCar(@PathVariable(name="id") String  id) {
		return paymentService.GetPayment(id);	
	};
	
	
	@GetMapping()
	public ArrayList<ReceiptPayment> getAll(){
		return paymentService.getAllPayment();
	}

}
