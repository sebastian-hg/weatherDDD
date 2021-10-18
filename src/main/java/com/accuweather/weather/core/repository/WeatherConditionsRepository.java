package com.accuweather.weather.core.repository;

import com.accuweather.weather.core.model.WeatherCondition;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface WeatherConditionsRepository {
    Flux<WeatherCondition> findAll();

    Mono<WeatherCondition> findById(Long id);

    Mono<WeatherCondition> save(WeatherCondition weatherConditions);

    Mono<Void> delete(Long id);
}
