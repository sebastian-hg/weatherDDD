package com.accuweather.weather.infrastucture.jpa.mapper;

import com.accuweather.weather.core.model.Country;
import com.accuweather.weather.infrastucture.jpa.domain.JpaCountry;
import reactor.core.publisher.Mono;

public interface CountryMapper {
    Mono<Country> toDomain(JpaCountry jpaCountry);

    Mono<JpaCountry> toJpa(Country country);

}
