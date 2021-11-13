package com.accuweather.weather.core.repository;

import com.accuweather.weather.api.dto.request.WeatherAllResponseDto;
import com.accuweather.weather.core.model.City;
import reactor.core.publisher.Mono;

public interface OpenWeatherClientApiRepository {
    Mono<City> execute(String city);
}
