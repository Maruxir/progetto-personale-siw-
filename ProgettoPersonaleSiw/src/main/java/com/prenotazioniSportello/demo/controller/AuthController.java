package com.prenotazioniSportello.demo.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.prenotazioniSportello.demo.model.Reservation;
import com.prenotazioniSportello.demo.service.ReservationService;

@Controller
public class AuthController {
	@Autowired
	ReservationService reservationService;

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
}
