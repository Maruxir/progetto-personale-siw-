package com.prenotazioniSportello.demo.service;

import java.time.LocalDate;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.prenotazioniSportello.demo.model.Reservation;
import com.prenotazioniSportello.demo.repository.ReservationRepository;

@Service
public class ReservationService {
	
	@Autowired 
	ReservationRepository reservationRepository;
	
	public ArrayList<Reservation> findAll() {
		return reservationRepository.findAll();
	}

	public void save(Reservation reservation) {
		reservationRepository.save(reservation);
		
	}

	public ArrayList<Reservation> findByDate(LocalDate date) {
		return reservationRepository.findByDate(date);
	}
}
