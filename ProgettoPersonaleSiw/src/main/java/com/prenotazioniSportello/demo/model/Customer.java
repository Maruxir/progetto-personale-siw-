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
	private LocalDateTime birthDate;
	@OneToMany(mappedBy = "customer")
	private List<Reservation> reservations; 
	
	public int getId_Customer() {
		return id_Customer;
	}
	public String getName() {
		return name;
	}
	public String getSurname() {
		return surname;
	}
	public LocalDateTime getBirthDate() {
		return birthDate;
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
	public void setBirthDate(LocalDateTime birthDate) {
		this.birthDate = birthDate;
	}
}
