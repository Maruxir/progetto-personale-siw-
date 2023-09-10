package com.prenotazioniSportello.demo.repository;

import java.util.ArrayList;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.prenotazioniSportello.demo.model.Reservation;

@Repository
public interface ReservationRepository extends CrudRepository<Reservation, Integer>{ 
	
	ArrayList<Reservation> findAll();
}
