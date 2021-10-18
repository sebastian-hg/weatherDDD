package com.accuweather.weather.infrastucture.jpa.mapper;

import com.accuweather.weather.core.model.City;
import com.accuweather.weather.infrastucture.jpa.domain.JpaCity;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.List;

public interface CityMapper {
    Mono<List<City>> toDomain(List<JpaCity> cities);

    Mono<City> toDomain(JpaCity jpaCity);

    Mono<JpaCity> toJpa(City city);
}
