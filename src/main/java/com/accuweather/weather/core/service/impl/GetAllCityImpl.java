package com.accuweather.weather.core.service.impl;

import com.accuweather.weather.core.model.City;
import com.accuweather.weather.core.repository.CityRepository;
import com.accuweather.weather.core.service.GetAllCity;
import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;
import reactor.core.publisher.Flux;

@Log4j2
@AllArgsConstructor
public class GetAllCityImpl implements GetAllCity {

    private final CityRepository repository;

    @Override
    public Flux<City> execute() {
        return repository.findAll();
    }
}
