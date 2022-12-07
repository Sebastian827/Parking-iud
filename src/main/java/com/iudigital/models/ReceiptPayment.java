package com.iudigital.models;

import java.time.LocalDateTime;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="receipt_payment")
public class ReceiptPayment {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	private String userName;
	
	private String plates;
	
	private Long value;
	
	
	private int registerId;
	
	private LocalDateTime checkIn;
	
	private LocalDateTime checkOut;
	
	private int hours;
	
	private int cell;
	
	

	public int getCell() {
		return cell;
	}



	public void setCell(int cell) {
		this.cell = cell;
	}



	public int getRegisterId() {
		return registerId;
	}



	public LocalDateTime getCheckIn() {
		return checkIn;
	}

	public void setCheckIn(LocalDateTime checkIn) {
		this.checkIn = checkIn;
	}

	public LocalDateTime getCheckOut() {
		return checkOut;
	}

	public void setCheckOut(LocalDateTime checkOut) {
		this.checkOut = checkOut;
	}

	public int getHours() {
		return hours;
	}

	public void setHours(int hours) {
		this.hours = hours;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPlates() {
		return plates;
	}

	public void setPlates(String plates) {
		this.plates = plates;
	}

	public Long getValue() {
		return value;
	}

	public void setValue(Long value) {
		this.value = value;
	}

	

	public void setRegisterId(int registerId) {
		this.registerId = registerId;
	}

	public ReceiptPayment() {
		
	}
	
	
	
	
	
	
	}
