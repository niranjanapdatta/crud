package com.example.crud.services.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.crud.entities.Hero;
import com.example.crud.exceptions.CustomException;
import com.example.crud.repositories.HeroRepository;
import com.example.crud.services.HeroService;

@Service
public class HeroServiceImpl implements HeroService{

	private HeroRepository heroRepository;
	
	public HeroServiceImpl(HeroRepository heroRepository) {
		super();
		this.heroRepository = heroRepository;
	}

	@Override
	public Hero saveHero(Hero hero) {
		return heroRepository.save(hero);
	}

	@Override
	public List<Hero> findHeroes() {
		return heroRepository.findAll();
	}

	@Override
	public Hero findHero(short id) {
		return heroRepository.findById(id).orElseThrow(() -> new CustomException("Hero", "id", id));
	}

	@Override
	public Hero updateHero(short id, Hero hero) {
		Hero existingHero = heroRepository.findById(id).orElseThrow(() -> new CustomException("Hero", "id", id));
		
		existingHero.setName(hero.getName());
		existingHero.setCategory(hero.getCategory());
		
		return heroRepository.save(existingHero);
	}

	@Override
	public void deleteHero(short id) {
		heroRepository.findById(id).orElseThrow(() -> new CustomException("Hero", "id", id));
		
		heroRepository.deleteById(id);
	}

}
