package com.accuweather.weather.infrastucture.jpa.mapper.impl;

import com.accuweather.weather.core.model.WeatherCondition;
import com.accuweather.weather.infrastucture.jpa.domain.JpaWeatherCondition;
import com.accuweather.weather.infrastucture.jpa.mapper.WeatherConditionMapper;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
public class WeatherConditionMapperImpl implements WeatherConditionMapper {
    @Override
    public Mono<WeatherCondition> toDomain(JpaWeatherCondition jpaWeatherCondition) {
        return Mono.just(WeatherCondition.builder()
                .id(jpaWeatherCondition.getId())
                .humidity(jpaWeatherCondition.getHumidity())
                .temperature(jpaWeatherCondition.getTemperature())
                .time(jpaWeatherCondition.getTime())
                .wind(jpaWeatherCondition.getWind())
                .build());
    }

    @Override
    public Mono<JpaWeatherCondition> toJpa(WeatherCondition weatherConditions) {
        return Mono.just(JpaWeatherCondition.builder()
                .id(weatherConditions.getId())
                .humidity(weatherConditions.getHumidity())
                .temperature(weatherConditions.getTemperature())
                .time(weatherConditions.getTime())
                .wind(weatherConditions.getWind())
                .build());
    }
}
