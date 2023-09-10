package com.prenotazioniSportello.demo.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.prenotazioniSportello.demo.model.Administrator;
@Repository
public interface AdministratorRepository extends CrudRepository<Administrator, Integer> {
	
	Administrator findByEmail(String email);

	
}
