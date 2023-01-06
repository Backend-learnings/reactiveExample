package com.example.reactiveExample.service;

import com.example.reactiveExample.document.SuperHero;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface SuperHeroService {
  Flux<SuperHero> findAll();
  Mono<SuperHero> save(SuperHero superHero);
}
