package com.accuweather.weather.core.service;

import com.accuweather.weather.core.model.City;
import reactor.core.publisher.Mono;

@FunctionalInterface
public interface GetWeatherByCity {
    Mono<City> execute(String city);
}
