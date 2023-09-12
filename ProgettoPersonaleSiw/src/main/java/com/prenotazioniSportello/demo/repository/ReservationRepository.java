package com.prenotazioniSportello.demo.repository;

import java.time.LocalDate;
import java.util.ArrayList;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.prenotazioniSportello.demo.model.Category;
import com.prenotazioniSportello.demo.model.Reservation;

@Repository
public interface ReservationRepository extends CrudRepository<Reservation, Integer>{ 
	
	@Query(value = "select * from reservation order by date, time", nativeQuery= true)
	ArrayList<Reservation> findAll();
	
	Reservation save(Reservation reservation);
	
	
	ArrayList<Reservation> findByDate(LocalDate date);
	
	Reservation findById(int id); 
	
	void delete(Reservation reservation);

	ArrayList<Reservation> findByCategory(Category category);
}
