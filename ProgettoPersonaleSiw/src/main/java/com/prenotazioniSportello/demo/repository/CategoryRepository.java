package com.prenotazioniSportello.demo.repository;

import java.util.ArrayList;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.prenotazioniSportello.demo.model.Category;

@Repository
public interface CategoryRepository extends CrudRepository<Category, Integer>{
	
	ArrayList<Category> findAll();

	Category findByName(String categoryName);
}
