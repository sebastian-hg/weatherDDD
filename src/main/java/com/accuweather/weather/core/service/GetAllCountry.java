package com.accuweather.weather.core.service;

import com.accuweather.weather.core.model.Country;
import reactor.core.publisher.Flux;

@FunctionalInterface
public interface GetAllCountry {
    Flux<Country> execute();
}
