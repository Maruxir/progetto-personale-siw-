package com.prenotazioniSportello.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.prenotazioniSportello.demo.model.Customer;
import com.prenotazioniSportello.demo.repository.CustomerRepository;

@Service
public class CustomerService {
	
	@Autowired
	CustomerRepository customerRepository;

	public Customer findOrCreate(String name, String surname, String email) {
		Customer customer = customerRepository.findByEmail(email);
		if(customer == null) {
			customer = new Customer();
			customer.setName(name);
			customer.setSurname(surname);
			customer.setPhoneNumber(email);
			customerRepository.save(customer);
			}
		return customer;
	}

	
}
