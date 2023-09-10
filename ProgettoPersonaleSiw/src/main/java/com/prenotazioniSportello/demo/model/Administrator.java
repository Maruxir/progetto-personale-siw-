package com.prenotazioniSportello.demo.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Administrator {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id_Administrator;
	
	private String email; 
	private String password;
	@ManyToOne
    @JoinColumn(name = "role_id")
	private Roles role;
	
	public int getId_Administrator() {
		return id_Administrator;
	}
	public String getEmail() {
		return email;
	}
	public String getPassword() {
		return password;
	}
	public void setId_Administrator(int id_Administrator) {
		this.id_Administrator = id_Administrator;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public Roles getRole() {
		return role;
	}
	public void setRole(Roles role) {
		this.role = role;
	} 
}
