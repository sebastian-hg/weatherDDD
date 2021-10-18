package com.accuweather.weather.infrastructure.Jpa.mapper;

import com.accuweather.weather.core.model.City;
import com.accuweather.weather.core.model.Country;
import com.accuweather.weather.core.model.WeatherCondition;
import com.accuweather.weather.infrastucture.jpa.domain.JpaCity;
import com.accuweather.weather.infrastucture.jpa.domain.JpaCountry;
import com.accuweather.weather.infrastucture.jpa.domain.JpaWeatherCondition;
import com.accuweather.weather.infrastucture.jpa.mapper.CountryMapper;
import com.accuweather.weather.infrastucture.jpa.mapper.WeatherConditionMapper;
import com.accuweather.weather.infrastucture.jpa.mapper.impl.CityMapperImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import reactor.core.publisher.Mono;
import reactor.test.StepVerifier;

import static org.mockito.ArgumentMatchers.any;

@ExtendWith(SpringExtension.class)
public class CityMapperTest {
    private JpaCity jpaCityRequest;
    private JpaCountry jpaCountryRequest;
    private JpaWeatherCondition jpaWeatherConditionRequest;
    private Country country;
    private WeatherCondition weatherCondition;
    private City cityExpected;
    private Mono<City> cityResponse;
    private City domainCityRequest;
    private JpaCity jpaCityExpected;
    private Mono<JpaCity> jpaCityResponse;
    @Mock
    private CountryMapper countryMapper;
    @Mock
    private WeatherConditionMapper conditionMapper;

    @InjectMocks
    private CityMapperImpl cityMapper;

    @BeforeEach
    void Setup() {
        jpaCountryRequest = JpaCountry.builder()
                .id(5L)
                .name("ven")
                .PostalCode(58)
                .build();
        jpaWeatherConditionRequest = JpaWeatherCondition.builder()
                .id(2L)
                .wind(33.33)
                .humidity(50.00)
                .temperature(12.99)
                .build();

    }

    @Test
    void givenRequestWhenExecuteToDomainThenIsOk() {
        givenJpaRequest();
        givenDomainMapper();
        givenDomainResponse();
        whenExecuteToDomain();
        thenToDomainIsOk();
    }

    private void givenJpaRequest() {
        jpaCityRequest = JpaCity.builder()
                .id(1L)
                .name("ven")
                .jpaWeatherCondition(jpaWeatherConditionRequest)
                .jpaCountry(jpaCountryRequest)
                .build();
    }

    private void givenDomainMapper() {
        country = Country.builder()
                .id(1L)
                .name("ven")
                .PostalCode(58)
                .build();
        weatherCondition = WeatherCondition.builder()
                .id(2L)
                .wind(33.33)
                .humidity(50.00)
                .temperature(12.99)
                .build();

        Mockito.when(countryMapper.toDomain(jpaCityRequest.getJpaCountry())).thenReturn(Mono.just(country));
        Mockito.when(conditionMapper.toDomain(jpaCityRequest.getJpaWeatherCondition()))
                .thenReturn(Mono.just(weatherCondition));
    }

    private void givenDomainResponse() {
        cityExpected = City.builder()
                .id(1L)
                .name("ven")
                .country(country)
                .weatherCondition(weatherCondition)
                .build();
    }

    private void whenExecuteToDomain() {
        cityResponse = cityMapper.toDomain(jpaCityRequest);
    }

    private void thenToDomainIsOk() {
        StepVerifier.create(cityResponse)
                .expectNextMatches(city -> city.equals(cityExpected))
                .expectComplete()
                .verify();
        Mockito.verify(countryMapper).toDomain(jpaCityRequest.getJpaCountry());
        Mockito.verify(conditionMapper).toDomain(jpaCityRequest.getJpaWeatherCondition());
    }
    @Test
    void givenRequestWhenExecuteToJpaThenIsOk() {
        givenDomainRequest();
        givenJpaMapper();
        givenJpaResponse();
        whenExecuteToJpa();
        thenToJpaIsOk();
    }

    private void givenDomainRequest() {
        domainCityRequest = City.builder()
                .id(1L)
                .name("cordoba")
                .country(Country.builder().build())
                .weatherCondition(WeatherCondition.builder().build())
                .build();
    }

    private void givenJpaMapper() {
        Mockito.when(countryMapper.toJpa(any())).thenReturn(Mono.just(JpaCountry.builder().build()));
        Mockito.when(conditionMapper.toJpa(any()))
                .thenReturn(Mono.just(JpaWeatherCondition.builder().build()));
    }

    private void givenJpaResponse() {
        jpaCityExpected = JpaCity.builder()
                .id(1L)
                .name("cordoba")
                .jpaCountry(JpaCountry.builder().build())
                .jpaWeatherCondition(JpaWeatherCondition.builder().build())
                .build();
    }

    private void whenExecuteToJpa() {
        jpaCityResponse = cityMapper.toJpa(domainCityRequest);
    }

    private void thenToJpaIsOk() {
        StepVerifier.create(jpaCityResponse)
                .expectNextMatches(jpaCity -> jpaCity.equals(jpaCityExpected))
                .expectComplete()
                .verify();
        Mockito.verify(countryMapper).toJpa(any());
        Mockito.verify(conditionMapper).toJpa(any());
    }
}
