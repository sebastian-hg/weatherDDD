package com.accuweather.weather.core.mapper;

import com.accuweather.weather.api.dto.request.WeatherAllResponseDto;
import com.accuweather.weather.core.model.City;
import reactor.core.publisher.Mono;

public interface ApiToCoreMapper {
    Mono<City> toCity(WeatherAllResponseDto weatherAllResponseDto);
}
