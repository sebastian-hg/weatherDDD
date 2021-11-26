package com.accuweather.weather.infrastucture.jpa.mapper.impl;

import com.accuweather.weather.core.model.City;
import com.accuweather.weather.infrastucture.jpa.domain.JpaCity;
import com.accuweather.weather.infrastucture.jpa.mapper.CityMapper;
import com.accuweather.weather.infrastucture.jpa.mapper.CountryMapper;
import com.accuweather.weather.infrastucture.jpa.mapper.WeatherConditionMapper;
import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

import java.util.ArrayList;
import java.util.List;

@Log4j2
@Service
@AllArgsConstructor
public class CityMapperImpl implements CityMapper {

    private final CountryMapper countryMapper;
    private final WeatherConditionMapper weatherConditionMapper;

    @Override
    public Mono<List<City>> toDomain(List<JpaCity> jpaCities) {
        log.debug("(infrastructure) information list <jpaCity> receiving {}", jpaCities);
        List<City> cityList = new ArrayList<>();
        jpaCities.forEach(jpaCity -> toDomain(jpaCity)
                .map(cityList::add));
        log.debug("(infrastructure) result mapped to list<jpaCity> {} ",cityList);
        return Mono.just(cityList);
    }

    @Override
    public Mono<City> toDomain(JpaCity jpaCity) {
        log.debug("(infrastructure) information jpaCity receiving {}", jpaCity);
        Mono<City> city = countryMapper.toDomain(jpaCity.getJpaCountry())
                .zipWith(weatherConditionMapper.toDomain(jpaCity.getJpaWeatherCondition()))
                .map(tuple2 -> City.builder()
                        .id(jpaCity.getId())
                        .name(jpaCity.getName())
                        .country(tuple2.getT1())
                        .weatherCondition(tuple2.getT2())
                        .build());
        log.debug("(infrastructure) result mapped jpaCity to city {}", city);
        return city;
    }

    @Override
    public Mono<JpaCity> toJpa(City city) {
        log.debug("(infrastructure) information receiving city {}", city);
        Mono<JpaCity> jpa = countryMapper.toJpa(city.getCountry())
                .zipWith(weatherConditionMapper.toJpa(city.getWeatherCondition()))
                .map(tuple2 -> JpaCity.builder()
                        .id(city.getId())
                        .name(city.getName())
                        .jpaCountry(tuple2.getT1())
                        .jpaWeatherCondition(tuple2.getT2())
                        .build());
        log.debug("(infrastructure) result mapped city to jpaCity {}",jpa);
        return jpa;
    }
}
