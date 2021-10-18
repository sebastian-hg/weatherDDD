package com.accuweather.weather.infrastucture.jpa.repository;

import com.accuweather.weather.infrastucture.jpa.domain.JpaCountry;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface JpaCountryRepository extends JpaRepository<JpaCountry, Long> {
    Optional<JpaCountry> findByName(String name);
}
