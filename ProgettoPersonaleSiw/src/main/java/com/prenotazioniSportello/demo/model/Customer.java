package com.prenotazioniSportello.demo.model;

import java.time.LocalDateTime;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class Customer {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id_Customer;
	private String name;
	private String surname; 
	private String email;
	@OneToMany(mappedBy = "customer")
	private List<Reservation> reservations; 
	
	public Customer () {}
	
	public int getId_Customer() {
		return id_Customer;
	}
	public String getName() {
		return name;
	}
	public String getSurname() {
		return surname;
	}

	public void setId_Customer(int id_Customer) {
		this.id_Customer = id_Customer;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void setSurname(String surname) {
		this.surname = surname;
	}
	public String getPhoneNumber() {
		return email;
	}
	public void setPhoneNumber(String email) {
		this.email= email;
	}

}
