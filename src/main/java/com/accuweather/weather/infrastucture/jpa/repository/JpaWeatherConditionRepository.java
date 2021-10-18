package com.accuweather.weather.infrastucture.jpa.repository;

import com.accuweather.weather.infrastucture.jpa.domain.JpaWeatherCondition;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JpaWeatherConditionRepository extends JpaRepository<JpaWeatherCondition, Long> {
}
