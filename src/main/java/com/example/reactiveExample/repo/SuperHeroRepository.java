package com.example.reactiveExample.repo;

import com.example.reactiveExample.document.SuperHero;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SuperHeroRepository extends ReactiveMongoRepository<SuperHero, String> {
}
