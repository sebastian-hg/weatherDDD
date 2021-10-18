package com.accuweather.weather.infrastucture.jpa.mapper.impl;

import com.accuweather.weather.core.model.City;
import com.accuweather.weather.infrastucture.jpa.domain.JpaCity;
import com.accuweather.weather.infrastucture.jpa.mapper.CityMapper;
import com.accuweather.weather.infrastucture.jpa.mapper.CountryMapper;
import com.accuweather.weather.infrastucture.jpa.mapper.WeatherConditionMapper;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
public class CityMapperImpl implements CityMapper {

    private final CountryMapper countryMapper;
    private final WeatherConditionMapper weatherConditionMapper;

    @Override
    public Mono<List<City>> toDomain(List<JpaCity> jpaCities) {
        List<City> cityList = new ArrayList<>();
        jpaCities.forEach(jpaCity -> toDomain(jpaCity)
                .map(cityList::add));
        return Mono.just(cityList) ;
    }

    @Override
    public Mono<City> toDomain(JpaCity jpaCity) {
        return countryMapper.toDomain(jpaCity.getJpaCountry())
                .zipWith(weatherConditionMapper.toDomain(jpaCity.getJpaWeatherCondition()))
                .map(tuple2 -> City.builder()
                        .id(jpaCity.getId())
                        .name(jpaCity.getName())
                        .country(tuple2.getT1())
                        .weatherCondition(tuple2.getT2())
                        .build());
    }

    @Override
    public Mono<JpaCity> toJpa(City city) {
        return countryMapper.toJpa(city.getCountry())
                .zipWith(weatherConditionMapper.toJpa(city.getWeatherCondition()))
                .map(tuple2 -> JpaCity.builder()
                        .id(city.getId())
                        .name(city.getName())
                        .jpaCountry(tuple2.getT1())
                        .jpaWeatherCondition(tuple2.getT2())
                        .build());
    }
}
