package com.prenotazioniSportello.demo.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.prenotazioniSportello.demo.model.Customer;

@Repository
public interface CustomerRepository extends CrudRepository<Customer, Integer>{
	
	@Query(value = "select * from customer a where a.email = ?1", nativeQuery = true)
	Customer findByEmail(String email);
	
	Customer save(Customer customer);

	
}
