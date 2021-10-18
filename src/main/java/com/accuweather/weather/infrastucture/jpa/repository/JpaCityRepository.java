package com.accuweather.weather.infrastucture.jpa.repository;

import com.accuweather.weather.infrastucture.jpa.domain.JpaCity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface JpaCityRepository extends JpaRepository<JpaCity, Long> {
    Optional<JpaCity> findByName(String name);
}
