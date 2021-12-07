package com.accuweather.weather.api.mapper.impl;

import com.accuweather.weather.api.dto.request.WeatherAllResponseDto;
import com.accuweather.weather.core.mapper.ApiToCoreMapper;
import com.accuweather.weather.core.model.City;
import com.accuweather.weather.core.model.Country;
import com.accuweather.weather.core.model.WeatherCondition;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

import java.time.LocalDateTime;

@Log4j2
@Service
public class ApiCityMapperImpl implements ApiToCoreMapper {

    @Override
    public Mono<City> toCity(WeatherAllResponseDto weatherAllResponseDto) {
        log.debug("(api) information weatherAllResponseDto receiving {}", weatherAllResponseDto);
        City toCity = City.builder()
                .id(weatherAllResponseDto.getId())
                .name(weatherAllResponseDto.getName())
                .weatherCondition(WeatherCondition.builder()
                        .humidity(weatherAllResponseDto.getMain().getHumidity())
                        .time(LocalDateTime.now())
                        .temperature(weatherAllResponseDto.getMain().getTemp())
                        .wind(weatherAllResponseDto.getWind().getSpeed())
                        .build())
                .country(
                        Country.builder()
                                .name(weatherAllResponseDto.getSys().getCountry())
                                .idSource(weatherAllResponseDto.getSys().getId())
                                .postalCode(weatherAllResponseDto.getCod())
                                .build()
                )
                .build();
        log.debug("(api) result mapped to city {}", toCity);
        return Mono.just(toCity);
    }

}
