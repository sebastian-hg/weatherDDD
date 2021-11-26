package com.accuweather.weather.infrastucture.jpa.mapper.impl;

import com.accuweather.weather.core.model.Country;
import com.accuweather.weather.infrastucture.jpa.domain.JpaCountry;
import com.accuweather.weather.infrastucture.jpa.mapper.CountryMapper;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Log4j2
@Service
public class CountryMapperImpl implements CountryMapper {
    @Override
    public Mono<Country> toDomain(JpaCountry jpaCountry) {
        log.debug("(infrastructure) information jpaCountry receiving {}", jpaCountry);
        Country domain = Country.builder()
                .id(jpaCountry.getId())
                .idSource(jpaCountry.getIdSource())
                .name(jpaCountry.getName())
                .postalCode(jpaCountry.getPostalCode())
                .build();
        log.debug("(infrastructure) result mapped to domain {}", domain);
        return Mono.just(domain);
    }

    @Override
    public Mono<JpaCountry> toJpa(Country country) {
        log.debug("(infrastructure) information country receiving country {}", country);
        JpaCountry jpa = JpaCountry.builder()
                .id(country.getId())
                .idSource(country.getIdSource())
                .name(country.getName())
                .postalCode(country.getPostalCode())
                .build();
        log.debug("(infrastructure) result mapped to jpa {}", jpa);
        return Mono.just(jpa);
    }
}
