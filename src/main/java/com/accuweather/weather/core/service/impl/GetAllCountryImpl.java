package com.accuweather.weather.core.service.impl;

import com.accuweather.weather.core.model.Country;
import com.accuweather.weather.core.repository.CountryRepository;
import com.accuweather.weather.core.service.GetAllCountry;
import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;
import reactor.core.publisher.Flux;

@Log4j2
@AllArgsConstructor
public class GetAllCountryImpl implements GetAllCountry {

    private final CountryRepository repository;

    @Override
    public Flux<Country> execute() {
        return repository.findAll();
    }
}
