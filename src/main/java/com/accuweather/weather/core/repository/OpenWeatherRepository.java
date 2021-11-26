package com.accuweather.weather.core.repository;

import com.accuweather.weather.core.model.City;
import reactor.core.publisher.Mono;

public interface OpenWeatherRepository {
    Mono<City> findByName(String city);
}
