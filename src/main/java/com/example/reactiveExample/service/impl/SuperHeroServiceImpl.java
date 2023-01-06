package com.example.reactiveExample.service.impl;

import com.example.reactiveExample.document.SuperHero;
import com.example.reactiveExample.repo.SuperHeroRepository;
import com.example.reactiveExample.service.SuperHeroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class SuperHeroServiceImpl implements SuperHeroService {

  @Autowired
  private SuperHeroRepository superHeroRepository;

  @Override
  public Flux<SuperHero> findAll() {
    return superHeroRepository.findAll();
  }

  @Override
  public Mono<SuperHero> save(SuperHero superHero) {
    return superHeroRepository.save(superHero);
  }
}
