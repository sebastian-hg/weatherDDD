package com.accuweather.weather.infrastucture.jpa.mapper;

import com.accuweather.weather.core.model.WeatherCondition;
import com.accuweather.weather.infrastucture.jpa.domain.JpaWeatherCondition;
import reactor.core.publisher.Mono;

public interface WeatherConditionMapper {
    Mono<WeatherCondition> toDomain(JpaWeatherCondition jpaWeatherCondition);

    Mono<JpaWeatherCondition> toJpa(WeatherCondition weatherConditions);
}
