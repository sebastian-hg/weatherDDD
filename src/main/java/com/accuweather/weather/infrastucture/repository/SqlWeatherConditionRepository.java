package com.accuweather.weather.infrastucture.repository;

import com.accuweather.weather.core.model.WeatherCondition;
import com.accuweather.weather.core.repository.WeatherConditionsRepository;
import com.accuweather.weather.infrastucture.jpa.mapper.WeatherConditionMapper;
import com.accuweather.weather.infrastucture.jpa.repository.JpaWeatherConditionRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Repository
@AllArgsConstructor
public class SqlWeatherConditionRepository implements WeatherConditionsRepository {

    private final WeatherConditionMapper weatherConditionMapper;
    private final JpaWeatherConditionRepository jpaWeatherCondition;

    @Override
    public Flux<WeatherCondition> findAll() {
        return null;
    }

    @Override
    public Mono<WeatherCondition> findById(Long id) {
        var weatherCondition = jpaWeatherCondition.findById(id);
        return weatherCondition.map(weatherConditionMapper::toDomain).orElse(Mono.empty());
    }

    @Override
    public Mono<WeatherCondition> save(WeatherCondition weatherConditions) {
        return weatherConditionMapper.toJpa(weatherConditions).map(jpaWeatherCondition::save)
                .flatMap(weatherConditionMapper::toDomain);
    }

    @Override
    public Mono<Void> delete(Long id) {
        jpaWeatherCondition.deleteById(id);
        return Mono.empty().then();
    }
}
