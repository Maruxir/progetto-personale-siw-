package com.prenotazioniSportello.demo.model;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class Category {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id_Category;
	private String name;
	@OneToMany(mappedBy = "category")
	private List<Reservation> reservations; 
	
	public int getId_Category() {
		return id_Category;
	}
	public String getName() {
		return name;
	}
	public void setId_Category(int id_Category) {
		this.id_Category = id_Category;
	}
	public void setName(String name) {
		this.name = name;
	}
}
