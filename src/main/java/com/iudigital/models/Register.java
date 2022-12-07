package com.iudigital.models;

import java.time.LocalDate;
import java.time.LocalDateTime;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name="register")
public class Register {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idregister;
	
	@ManyToOne(cascade=CascadeType.MERGE)
	@JoinColumn(name="car_id")
	private Car car;
	
	@Column(name = "check_in")
	private LocalDateTime checkIn;
	
	@Column(name = "check_out")
	private LocalDateTime checkOut;
	
	private String news;
	private boolean state;
	private int cell;
	private long price;
	
	public int getCell() {
		return cell;
	}
	public void setCell(int cell) {
		this.cell=cell;
	}
	
	public int getIdregister() {
		return idregister;
	}
	public void setIdregister(int idregister) {
		this.idregister = idregister;
	}
	public Car getCar() {
		return car;
	}
	public void setCar(Car car) {
		this.car = car;
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
	public String getNews() {
		return news;
	}
	public void setNews(String news) {
		this.news = news;
	}
	public boolean isState() {
		return state;
	}
	public void setState(boolean state) {
		this.state = state;
	}
	public long getPrice() {
		return price;
	}
	public void setPrice(long price) {
		this.price = price;
	}
	
	

}
