package com.prenotazioniSportello.demo.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.prenotazioniSportello.demo.model.Category;
import com.prenotazioniSportello.demo.repository.CategoryRepository;

@Service
public class CategoryService {
	
	@Autowired
	CategoryRepository categoryRepository;

	public ArrayList<Category> findAll() {
		return categoryRepository.findAll();
	}

	public Category findByname(String categoryName) {
		return categoryRepository.findByName(categoryName);
	}
	
	

}
