package com.accuweather.weather.api.client.impl;

import com.accuweather.weather.api.configuration.ClientConfigProperties;
import com.accuweather.weather.api.dto.request.WeatherAllResponseDto;
import com.accuweather.weather.core.mapper.ApiToCoreMapper;
import com.accuweather.weather.core.model.City;
import com.accuweather.weather.core.repository.OpenWeatherRepository;
import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.reactive.function.client.WebClientException;
import reactor.core.publisher.Mono;

@AllArgsConstructor
@Component
@Log4j2
public class OpenWeatherClientApi implements OpenWeatherRepository {

    private final ApiToCoreMapper mapper;
    private final ClientConfigProperties configProperties;
    private static final String APP_ID = "&appid=8f472c70733460dde96a4490ebc9aa01";

    @Override
    public Mono<City> findByName(String city) {
        var params = "?q=" + city + APP_ID;
        return WebClient.create()
                .get()
                .uri(configProperties.getOpenWeatherUrl() + params)
                .header(HttpHeaders.ACCEPT, MediaType.APPLICATION_JSON_VALUE)
                .header(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
                .retrieve()
                .bodyToMono(WeatherAllResponseDto.class)
                .doOnNext(x -> log.debug("(api) data receiving by api client {}", x))
                .flatMap(mapper::toCity)
                .doOnNext(s -> log.debug("(api) result mapped api to core {}", s))
                .onErrorMap(e -> new WebClientException("Error during call in API" + e) {
                });
    }
}
