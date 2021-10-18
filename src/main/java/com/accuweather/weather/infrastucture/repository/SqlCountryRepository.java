package com.accuweather.weather.infrastucture.repository;

import com.accuweather.weather.core.model.Country;
import com.accuweather .weather.core.repository.CountryRepository;
import com.accuweather.weather.infrastucture.jpa.mapper.CountryMapper;
import com.accuweather.weather.infrastucture.jpa.repository.JpaCountryRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Repository
@AllArgsConstructor
public class SqlCountryRepository implements CountryRepository {

    private final JpaCountryRepository jpaCountryRepository;
    private final CountryMapper countryMapper;

    @Override
    public Flux<Country> findAll() {
        return null;
    }

    @Override
    public Mono<Country> findById(Long id) {
        var country= jpaCountryRepository.findById(id);
        return country.map(countryMapper::toDomain).orElse(Mono.empty());
    }

    @Override
    public Mono<Country> findByName(String name) {

        var country= jpaCountryRepository.findByName(name);
        return country.map(countryMapper::toDomain).orElse(Mono.empty());
    }

    @Override
    public Mono<Country> save(Country country) {
        return countryMapper.toJpa(country).map(jpaCountryRepository::save).flatMap(countryMapper::toDomain);
    }


    @Override
    public Mono<Void> delete(Long id) {
        jpaCountryRepository.deleteById(id);
        return Mono.empty().then();
    }
}
