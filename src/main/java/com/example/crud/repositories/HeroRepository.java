package com.example.crud.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.crud.entities.Hero;

public interface HeroRepository extends JpaRepository<Hero, Short> {

}
