package com.accuweather.weather.core.service.impl;

import com.accuweather.weather.core.model.City;
import com.accuweather.weather.core.repository.CityRepository;
import com.accuweather.weather.core.repository.OpenWeatherRepository;
import com.accuweather.weather.core.service.GetWeatherByCity;
import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;
import reactor.core.publisher.Mono;

@Log4j2
@AllArgsConstructor
public class GetWeatherByCityImpl implements GetWeatherByCity {

    private final OpenWeatherRepository openWeatherRepository;
    private final CityRepository cityRepository;

    @Override
    public Mono<City> execute(String city) {
        Mono<City> cityService = openWeatherRepository.findByName(city)
                .flatMap(cityRepository::save);
        log.debug("(core) service execute {}", cityService);
        return cityService;
    }
}
