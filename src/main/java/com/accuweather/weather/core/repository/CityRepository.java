package com.accuweather.weather.core.repository;

import com.accuweather.weather.core.model.City;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface CityRepository {
    Flux<City> findAll();

    Mono<City> findById(Long id);

    Mono<City> findByName(String name);

    Mono<City> save(City city);

    Mono<Void> delete(Long id);
}
