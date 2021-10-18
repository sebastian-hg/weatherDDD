package com.accuweather.weather.api.client;

import com.accuweather.weather.api.dto.WeatherAllResponseDto;
import reactor.core.publisher.Mono;

public interface OpenWeatherClientApi {
    Mono<WeatherAllResponseDto> execute(String city);
}
