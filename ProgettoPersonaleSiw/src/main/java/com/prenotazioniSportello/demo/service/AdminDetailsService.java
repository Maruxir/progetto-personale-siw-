package com.prenotazioniSportello.demo.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.prenotazioniSportello.demo.model.Administrator;
import com.prenotazioniSportello.demo.repository.AdministratorRepository;
import com.prenotazioniSportello.demo.repository.CustomerRepository;

@Service
public class AdminDetailsService implements UserDetailsService {
	
	private AdministratorRepository administratorRepository;
	
	 public AdminDetailsService(AdministratorRepository userRepository) {
	        this.administratorRepository = userRepository;
	    }
	
	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
		Administrator user = administratorRepository.findByEmail(email);
		
		if(user != null) {
			List<GrantedAuthority> authorities = new ArrayList<>();
			authorities.add(new SimpleGrantedAuthority("ROLE_" + user.getRole().getName()));
			return new org.springframework.security.core.userdetails.User(user.getEmail(), user.getPassword(), authorities);
		}
		else {
			throw new UsernameNotFoundException("Invalid username");
		}
	}

}
