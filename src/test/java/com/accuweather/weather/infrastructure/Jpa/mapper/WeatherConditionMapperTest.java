package com.accuweather.weather.infrastructure.Jpa.mapper;

import com.accuweather.weather.core.model.WeatherCondition;
import com.accuweather.weather.infrastucture.jpa.domain.JpaWeatherCondition;
import com.accuweather.weather.infrastucture.jpa.mapper.impl.WeatherConditionMapperImpl;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import reactor.core.publisher.Mono;
import reactor.test.StepVerifier;

@ExtendWith(SpringExtension.class)
public class WeatherConditionMapperTest {

    private JpaWeatherCondition jpaWeatherCondition;
    private WeatherCondition weatherConditionExpected;
    private Mono<WeatherCondition> weatherConditionResponse;
    private WeatherCondition weatherCondition;
    private JpaWeatherCondition jpaWeatherConditionExpected;
    private Mono<JpaWeatherCondition> jpaWeatherConditionResponse;


    @InjectMocks
    private WeatherConditionMapperImpl weatherConditionMapper;

    @Test
    void givenRequestWhenExecuteToDomainThemIsOk() {
        givenRequest();
        givenResponse();
        whenExecuteToDomain();
        themIsOk();
    }

    private void givenRequest() {
        jpaWeatherCondition = JpaWeatherCondition.builder()
                .id(1L)
                .wind(23.00)
                .humidity(33.33)
                .build();
    }

    private void givenResponse() {
        weatherConditionExpected = WeatherCondition.builder()
                .id(1L)
                .wind(23.00)
                .humidity(33.33)
                .build();
    }

    private void whenExecuteToDomain() {
        weatherConditionResponse = weatherConditionMapper.toDomain(jpaWeatherCondition);
    }

    private void themIsOk() {
        StepVerifier.create(weatherConditionResponse)
                .expectNextMatches(weatherCondition -> weatherCondition.equals(weatherConditionExpected))
                .expectComplete()
                .verify();
    }
    @Test
    void givenRequestWhenExecuteToJpaThemIsOk() {
        givenJpaRequest();
        givenJpaResponse();
        whenExecuteToJpa();
        themJpaIsOk();
    }

    private void givenJpaRequest() {
        weatherCondition = WeatherCondition.builder()
                .id(1L)
                .humidity(23.00)
                .wind(12.00)
                .build();
    }

    private void givenJpaResponse() {
        jpaWeatherConditionExpected = JpaWeatherCondition.builder()
                .id(1L)
                .humidity(23.00)
                .wind(12.00)
                .build();
    }

    private void whenExecuteToJpa() {
        jpaWeatherConditionResponse = weatherConditionMapper.toJpa(weatherCondition);
    }

    private void themJpaIsOk() {
        StepVerifier.create(jpaWeatherConditionResponse)
                .expectNextMatches(jpaWeatherCondition1 -> jpaWeatherCondition1.equals(jpaWeatherConditionExpected))
                .expectComplete()
                .verify();
    }

}
