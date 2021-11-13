package com.accuweather.weather.core.service;

import com.accuweather.weather.core.model.City;
import reactor.core.publisher.Flux;

@FunctionalInterface
public interface GetAllCity {
    Flux<City> execute();
}
