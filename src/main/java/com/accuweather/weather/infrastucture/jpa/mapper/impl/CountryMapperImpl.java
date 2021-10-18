package com.accuweather.weather.infrastucture.jpa.mapper.impl;

import com.accuweather.weather.core.model.Country;
import com.accuweather.weather.infrastucture.jpa.domain.JpaCountry;
import com.accuweather.weather.infrastucture.jpa.mapper.CountryMapper;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
public class CountryMapperImpl implements CountryMapper {
    @Override
    public Mono<Country> toDomain(JpaCountry jpaCountry) {
        return Mono.just(Country.builder()
                .id(jpaCountry.getId())
                .name(jpaCountry.getName())
                .PostalCode(jpaCountry.getPostalCode())
                .build());
    }

    @Override
    public Mono<JpaCountry> toJpa(Country country) {
        return Mono.just(JpaCountry.builder()
                .id(country.getId())
                .name(country.getName())
                .PostalCode(country.getPostalCode())
                .build());
    }
}
