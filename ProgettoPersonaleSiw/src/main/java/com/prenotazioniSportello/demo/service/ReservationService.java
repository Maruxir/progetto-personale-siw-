package com.prenotazioniSportello.demo.service;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.prenotazioniSportello.demo.model.Category;
import com.prenotazioniSportello.demo.model.Reservation;
import com.prenotazioniSportello.demo.repository.ReservationRepository;

@Service
public class ReservationService {
	
	@Autowired 
	ReservationRepository reservationRepository;
	
	public ArrayList<Reservation> findNext() {
		LocalDate todaysDate = LocalDate.now();
		ArrayList<Reservation> nextReservations = new ArrayList<Reservation>();
		ArrayList<Reservation> allReservations = reservationRepository.findAll();
		for(Reservation r : allReservations) {
			if(r.getDate().isAfter(todaysDate)) {
				nextReservations.add(r);
			}
		}
		return nextReservations;
	}
	
	public ArrayList<Reservation> findToday() {
		LocalDate todaysDate = LocalDate.now();
		LocalTime todaysTime = LocalTime.now();
		ArrayList<Reservation> todayReservations = new ArrayList<Reservation>();
		ArrayList<Reservation> allReservations = reservationRepository.findAll();
		for(Reservation r : allReservations) {
			if(r.getDate().isEqual(todaysDate) && (r.getTime().equals(todaysTime) || r.getTime().isAfter(todaysTime))) {
				todayReservations.add(r);
			}
		}
		return todayReservations;
	}
	
	public ArrayList<Reservation> findPast() {
		LocalDate todaysDate = LocalDate.now();
		LocalTime todaysTime = LocalTime.now();
		ArrayList<Reservation> pastReservations = new ArrayList<Reservation>();
		ArrayList<Reservation> allReservations = reservationRepository.findAll();
		for(Reservation r : allReservations) {
			if((r.getDate().isBefore(todaysDate) || r.getDate().isEqual(todaysDate))&& r.getTime().isBefore(todaysTime)) {
				pastReservations.add(r);
			}
		}
		return pastReservations;
	}
	
	public ArrayList<Reservation> findAll() {
		return reservationRepository.findAll();
	}
	

	public void save(Reservation reservation) {
		reservationRepository.save(reservation);
		
	}

	public ArrayList<Reservation> findByDate(LocalDate date) {
		return reservationRepository.findByDate(date);
	}

	public void delete(int id) {
		Reservation reservation = reservationRepository.findById(id);
		if(reservation != null) {
		reservationRepository.delete(reservation); }
	}

	public Reservation findById(int idReservation) {
		return reservationRepository.findById(idReservation);
	}

	public ArrayList<Reservation> findByCategory(Category category) {
		return reservationRepository.findByCategory(category);
	}
}
