package com.accuweather.weather.infrastucture.jpa.mapper.impl;

import com.accuweather.weather.core.model.WeatherCondition;
import com.accuweather.weather.infrastucture.jpa.domain.JpaWeatherCondition;
import com.accuweather.weather.infrastucture.jpa.mapper.WeatherConditionMapper;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Log4j2
@Service
public class WeatherConditionMapperImpl implements WeatherConditionMapper {
    @Override
    public Mono<WeatherCondition> toDomain(JpaWeatherCondition jpaWeatherCondition) {
        log.debug("(infrastructure) receiving jpaWeatherCondition {}", jpaWeatherCondition);
        WeatherCondition domain = WeatherCondition.builder()
                .id(jpaWeatherCondition.getId())
                .humidity(jpaWeatherCondition.getHumidity())
                .temperature(jpaWeatherCondition.getTemperature())
                .time(jpaWeatherCondition.getTime())
                .wind(jpaWeatherCondition.getWind())
                .build();
        log.debug("(infrastructure) information mapper to domain {}", domain);
        return Mono.just(domain);
    }

    @Override
    public Mono<JpaWeatherCondition> toJpa(WeatherCondition weatherConditions) {
        log.debug(" (infrastructure) receiving weatherConditions {}", weatherConditions);
        JpaWeatherCondition jpa = JpaWeatherCondition.builder()
                .id(weatherConditions.getId())
                .humidity(weatherConditions.getHumidity())
                .temperature(weatherConditions.getTemperature())
                .time(weatherConditions.getTime())
                .wind(weatherConditions.getWind())
                .build();
        log.debug("(infrastructure) information mapped {}", jpa);
        return Mono.just(jpa);
    }
}
