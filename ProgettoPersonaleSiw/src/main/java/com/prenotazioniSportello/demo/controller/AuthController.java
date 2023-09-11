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

	@RequestMapping("/homeAdministrator")
	public String homeAdministrator(Model model) {
		ArrayList<Reservation> reservations = reservationService.findAll();
		model.addAttribute("reservations", reservations);
		return "homeAdministrator";
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
		String dateString = date;
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		LocalDate localDate = LocalDate.parse(dateString, formatter);
		
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
		
		ArrayList<Reservation> reservations = reservationService.findAll();
		model.addAttribute("reservations", reservations);
		return "homeAdministrator";
	}
	
	/*@RequestMapping("/addReservation") 
	public String addReservation(Model model, @RequestParam("name") String name, 
			@RequestParam("surname") String surname, @RequestParam("email") String email) {
		
		Customer customer = customerService.findOrCreate(name, surname, email);
		
		ArrayList<Reservation> reservations = reservationService.findAll();
		model.addAttribute("reservations", reservations);
		return "homeAdministrator";
	}*/
	
	
	
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

		ArrayList<Reservation> reservations = reservationService.findByDate(localDate);
		model.addAttribute("reservations", reservations);
		return "homeAdministrator";
	}
	
	

}
