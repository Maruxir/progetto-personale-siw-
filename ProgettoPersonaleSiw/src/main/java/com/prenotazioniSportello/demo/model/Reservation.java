package com.prenotazioniSportello.demo.model;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

@Entity
public class Reservation {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id_Reservation;
	private	LocalDate date;
	private LocalTime time;
	
	@ManyToOne
	private Customer customer; 
	@ManyToOne
	private Category category;
	
	public Reservation() {};
	
	public int getId_Reservation() {
		return id_Reservation;
	}
	public Customer getCustomer() {
		return customer;
	}
	public Category getCategory() {
		return category;
	}
	public void setId_Reservation(int id_Reservation) {
		this.id_Reservation = id_Reservation;
	}
	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
	public void setCategory(Category category) {
		this.category = category;
	}
	public LocalDate getDate() {
		return date;
	}
	public void setDate(LocalDate date) {
		this.date = date;
	}
	public LocalTime getTime() {
		return time;
	}
	public void setTime(LocalTime time) {
		this.time = time;
	}

	
}
