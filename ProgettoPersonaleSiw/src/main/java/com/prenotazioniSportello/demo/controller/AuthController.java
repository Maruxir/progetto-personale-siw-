package com.prenotazioniSportello.demo.controller;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.prenotazioniSportello.demo.model.Category;
import com.prenotazioniSportello.demo.model.Customer;
import com.prenotazioniSportello.demo.model.Reservation;
import com.prenotazioniSportello.demo.service.CategoryService;
import com.prenotazioniSportello.demo.service.CustomerService;
import com.prenotazioniSportello.demo.service.ReservationService;

@Controller
public class AuthController {
	@Autowired
	ReservationService reservationService;
	
	@Autowired
	CustomerService customerService;
	
	@Autowired 
	CategoryService categoryService;
	
	 private void updateModel(Model model) {
		
		 ArrayList<Category> categories = categoryService.findAll();
			model.addAttribute("categories", categories);
		 ArrayList<Reservation> todayreservations = reservationService.findToday();
			model.addAttribute("todayreservations", todayreservations);
			ArrayList<Reservation> reservations = reservationService.findNext();
			model.addAttribute("reservations", reservations);  
	    }
	
	
	@RequestMapping("/home")
	public String home() {
		return "home";
	}
	

	@RequestMapping("/homeAdministrator")
	public String homeAdministrator(Model model) {
		updateModel(model);
		return "homeAdministrator";
	}
	
	@RequestMapping("/pastReservation")
	public String pastReservation(Model model) {
		ArrayList<Reservation> pastReservations = reservationService.findPast();
		model.addAttribute("reservations", pastReservations);
		return "pastReservations";
	}
	
	@GetMapping("/login")
    public String login(){
        return "login";
    } 
	
	@RequestMapping("/addReservation") 
	public String addReservation(Model model, @RequestParam("name") String name, 
			@RequestParam("surname") String surname, @RequestParam("email") String email,
			@RequestParam("date") String date, @RequestParam("time") String time,
			@RequestParam("category") String categoryName) {
		
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		LocalDate localDate = LocalDate.parse(date, formatter);
		
		DateTimeFormatter timeFormatter = DateTimeFormatter.ofPattern("HH:mm");
		LocalTime localTime = LocalTime.parse(time, timeFormatter);
		
		Category category = categoryService.findByname(categoryName);
		
		Customer customer = customerService.findOrCreate(name, surname, email); 
				
		Reservation reservation = new Reservation();
		reservation.setCustomer(customer);
		reservation.setDate(localDate);
		reservation.setCategory(category);
		reservation.setTime(localTime);
		reservationService.save(reservation); 
		
		updateModel(model);
		return "homeAdministrator";
	}
	
	@RequestMapping("/addReservationCall") 
	public String addReservationCall(Model model) {
		ArrayList<Category> categories = categoryService.findAll();
		model.addAttribute("categories", categories);
		return "addReservation";
	}


	@RequestMapping("/reservationByDate/{date}")
	public String reservationByDate(Model model, @PathVariable String date ) {
		String dateString = date;
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		LocalDate localDate = LocalDate.parse(dateString, formatter);

		ArrayList<Category> categories = categoryService.findAll();
		model.addAttribute("categories", categories);
		ArrayList<Reservation> reservations = reservationService.findByDate(localDate);
		model.addAttribute("reservations", reservations);
		return "homeAdministrator";
	}
	
	
	@RequestMapping("/reservationByCategory") 
	public String reservationByCategory(Model model, @RequestParam("category") String categoryName) {
		Category category = categoryService.findByname(categoryName);
		
		ArrayList<Category> categories = categoryService.findAll();
		model.addAttribute("categories", categories);
		ArrayList<Reservation> reservations = reservationService.findByCategory(category);
		model.addAttribute("reservations", reservations);
		return "homeAdministrator";
	}

	@RequestMapping("/deleteReservation/{id}")
	public String deleteReservation(Model model, @PathVariable int id) {
		reservationService.delete(id);

		updateModel(model);
		return "homeAdministrator";
	} 
	
	@RequestMapping("/updateReservationCall")
	public String updateReservationCall() {
		return "updateReservation";
	}
	
	@RequestMapping("/updateReservation")
	public String updateReservation(Model model, @RequestParam("idReservation") int idReservation, 
			@RequestParam("date") String date, @RequestParam("time") String time) {
	DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
	LocalDate localDate = LocalDate.parse(date, formatter);
		
	DateTimeFormatter timeFormatter = DateTimeFormatter.ofPattern("HH:mm");
	LocalTime localTime = LocalTime.parse(time, timeFormatter);
	
	Reservation reservation = reservationService.findById(idReservation);
	
	if(reservation != null) {
		reservation.setDate(localDate);
		reservation.setTime(localTime);
		reservationService.save(reservation);
	}
	
	updateModel(model);
	return "homeAdministrator";
	}
}
