package com.accuweather.weather.infrastucture.repository;

import com.accuweather.weather.core.model.City;
import com.accuweather.weather.core.repository.CityRepository;
import com.accuweather.weather.infrastucture.jpa.mapper.CityMapper;
import com.accuweather.weather.infrastucture.jpa.repository.JpaCityRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Repository
@AllArgsConstructor
public class SqlCityRepository implements CityRepository {
    private final CityMapper cityMapper;
    private final JpaCityRepository cityRepository;

    @Override
    public Flux<City> findAll() {
        return null;
    }

    @Override
    public Mono<City> findById(Long id) {
        var city= cityRepository.findById(id);
        return city.map(cityMapper::toDomain).orElse(Mono.empty());
    }

    @Override
    public Mono<City> findByName(String name) {
        var city= cityRepository.findByName(name);
        return city.map(cityMapper::toDomain).orElse(Mono.empty());
    }

    @Override
    public Mono<City> save(City city) {
        return cityMapper.toJpa(city).map(cityRepository::save).flatMap(cityMapper::toDomain);
    }

    @Override
    public Mono<Void> delete(Long id) {
        cityRepository.deleteById(id);
        return Mono.empty().then();
    }
}
