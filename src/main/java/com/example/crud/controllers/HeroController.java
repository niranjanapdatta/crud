package com.example.crud.controllers;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.crud.entities.Hero;
import com.example.crud.services.HeroService;

@RestController
@RequestMapping("/heroes")
public class HeroController {

	private HeroService heroService;

	// Constructor-based dependency injection
	public HeroController(HeroService heroService) {
		super();
		this.heroService = heroService;
	}
	
	@PostMapping
	public ResponseEntity<Hero> saveHeroController(@RequestBody Hero hero) {
		return new ResponseEntity<Hero>(heroService.saveHero(hero), HttpStatus.CREATED);
	}

	@GetMapping
	public List<Hero> getHeroesController() {
		return heroService.findHeroes();
	}

	@GetMapping("{id}")
	public ResponseEntity<Hero> getHeroController(@PathVariable("id") short inputId) {
		return new ResponseEntity<Hero>(heroService.findHero(inputId), HttpStatus.OK);
	}
	
	@PutMapping("{id}")
	public ResponseEntity<Hero> updateHeroController(@PathVariable("id") short inputId, @RequestBody Hero hero) {
		return new ResponseEntity<Hero>(heroService.updateHero(inputId, hero), HttpStatus.OK);
	}

	@DeleteMapping("{id}")
	public ResponseEntity<String> deleteHeroController(@PathVariable("id") short inputId) {
		heroService.deleteHero(inputId);
		return new ResponseEntity<String>("Hero Deleted", HttpStatus.OK);
	}
}
