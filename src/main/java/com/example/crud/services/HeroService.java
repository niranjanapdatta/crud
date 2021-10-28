package com.example.crud.services;

import java.util.List;

import com.example.crud.entities.Hero;

public interface HeroService {
	Hero saveHero(Hero hero);

	List<Hero> findHeroes();
	
	Hero findHero(short id);

	Hero updateHero(short id, Hero hero);
	
	void deleteHero(short id);
}
