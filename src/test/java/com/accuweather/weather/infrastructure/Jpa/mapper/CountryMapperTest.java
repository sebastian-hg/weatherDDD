package com.accuweather.weather.infrastructure.Jpa.mapper;

import com.accuweather.weather.core.model.Country;
import com.accuweather.weather.infrastucture.jpa.domain.JpaCountry;
import com.accuweather.weather.infrastucture.jpa.mapper.impl.CountryMapperImpl;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import reactor.core.publisher.Mono;
import reactor.test.StepVerifier;

@ExtendWith(SpringExtension.class)
public class CountryMapperTest {

    private JpaCountry jpaCountry;
    private Country countryExpected;
    private Mono<Country> countryResponse;
    private JpaCountry jpaExpected;
    private Country country;
    private Mono<JpaCountry> jpaCountryResponse;

    @InjectMocks
    private CountryMapperImpl countryMapper;

    @Test
    void givenRequestWhenExecuteToDomainThenIsOk() {
        givenRequest();
        givenResponse();
        whenExecuteToDomain();
        thenIsOk();
    }

    private void givenRequest() {
        jpaCountry = JpaCountry.builder()
                .id(1L)
                .name("ven")
                .postalCode(58)
                .build();
    }

    private void givenResponse() {
        countryExpected = Country.builder()
                .id(1L)
                .name("ven")
                .postalCode(58)
                .build();
    }

    private void whenExecuteToDomain() {
        countryResponse = countryMapper.toDomain(jpaCountry);
    }

    private void thenIsOk() {
        StepVerifier.create(countryResponse)
                .expectNextMatches(country -> country.equals(countryExpected))
                .expectComplete()
                .verify();
    }

    @Test
    void givenRequestWhenExecuteToJpaThenIsOk() {
        givenJpaRequest();
        givenJpaResponse();
        whenExecuteToJpa();
        thenJpaIsOK();
    }

    private void givenJpaRequest() {
        country = Country.builder()
                .id(1L)
                .name("arg")
                .postalCode(54)
                .build();
    }

    private void givenJpaResponse() {
        jpaExpected = JpaCountry.builder()
                .id(1L)
                .name("arg")
                .postalCode(54)
                .build();
    }

    private void whenExecuteToJpa() {
        jpaCountryResponse = countryMapper.toJpa(country);
    }

    private void thenJpaIsOK() {
        StepVerifier.create(jpaCountryResponse)
                .expectNextMatches(jpaCountry1 -> jpaCountry1.equals(jpaExpected))
                .expectComplete()
                .verify();
    }

}
