package com.prenotazioniSportello.demo.repository;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.prenotazioniSportello.demo.model.Reservation;

@Repository
public interface ReservationRepository extends CrudRepository<Reservation, Integer>{ 
	
	ArrayList<Reservation> findAll();
	
	Reservation save(Reservation reservation);
	
	
	ArrayList<Reservation> findByDate(LocalDate date);
}
