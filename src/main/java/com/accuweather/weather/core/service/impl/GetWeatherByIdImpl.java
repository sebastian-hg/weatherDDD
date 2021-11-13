package com.accuweather.weather.core.service.impl;

import com.accuweather.weather.core.model.City;
import com.accuweather.weather.core.repository.CityRepository;
import com.accuweather.weather.core.service.GetWeatherByID;
import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;
import reactor.core.publisher.Mono;

@Log4j2
@AllArgsConstructor
public class GetWeatherByIdImpl implements GetWeatherByID {

    private final CityRepository repository;

    @Override
    public Mono<City> execute(Long id) {
        return repository.findById(id) ;
    }
}
