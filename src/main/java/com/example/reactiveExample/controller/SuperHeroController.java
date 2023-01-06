package com.example.reactiveExample.controller;

import com.example.reactiveExample.document.SuperHero;
import com.example.reactiveExample.repo.SuperHeroRepository;
import com.example.reactiveExample.service.SuperHeroService;
import com.example.reactiveExample.service.impl.SuperHeroServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.time.Duration;
import java.util.Map;

@RestController
public class SuperHeroController {
  @Autowired
  private SuperHeroService service;

  @RequestMapping(value = "/superhero", produces = MediaType.TEXT_EVENT_STREAM_VALUE)
  public Flux<SuperHero> getAllSuperHeros() {
    return service.findAll().delayElements(Duration.ofSeconds(3));
  }

  @PostMapping("/superhero")
  public Mono<SuperHero> addSuperHero(@RequestBody SuperHero superHero) {
    return service.save(superHero);
  }

  @GetMapping("/reactiveClient")
  public void sampleWeb() {
    Flux<Map> res = WebClient
        .builder()
        .baseUrl("http://localhost:9110/superhero")
        .build()
        .get()
        .retrieve()
        .bodyToFlux(Map.class);

    System.out.println(SuperHero.builder());
    res.subscribe(
        data -> {
          System.out.println(data);
        });
  }
}
