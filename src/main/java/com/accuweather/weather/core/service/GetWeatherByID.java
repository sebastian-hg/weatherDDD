package com.accuweather.weather.core.service;

import com.accuweather.weather.core.model.City;
import reactor.core.publisher.Mono;

@FunctionalInterface
public interface GetWeatherByID {
    Mono<City> execute(Long id);
}
