package com.accuweather.weather.core.service.impl;

import com.accuweather.weather.api.client.impl.OpenWeatherClientApiImpl;
import com.accuweather.weather.core.model.City;
import com.accuweather.weather.core.repository.CityRepository;
import com.accuweather.weather.core.service.GetWeatherByCity;
import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;
import reactor.core.publisher.Mono;

@Log4j2
@AllArgsConstructor
public class GetWeatherByCityImpl implements GetWeatherByCity {

    private final CityRepository repository;
   // private final OpenWeatherClientApiImpl openWeatherClientApi;

    @Override
    public Mono<City> execute(String city) {
       return repository.findByName(city);
    }
}
