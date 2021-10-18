package com.accuweather.weather.core.repository;

import com.accuweather.weather.core.model.Country;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface CountryRepository {
    Flux<Country> findAll();
    Mono<Country> findById(Long id);
    Mono<Country> findByName(String name);
    Mono<Country> save(Country country);
    Mono<Void> delete(Long id);
}
