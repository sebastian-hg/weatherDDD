package com.accuweather.weather.api.client.impl;

import com.accuweather.weather.api.client.OpenWeatherClientApi;
import com.accuweather.weather.api.configuration.ClientConfigProperties;
import com.accuweather.weather.api.dto.WeatherAllResponseDto;
import com.accuweather.weather.core.exception.ErrorInCallToApiException;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

@AllArgsConstructor
@Component
public class OpenWeatherClientApiImpl implements OpenWeatherClientApi {
    private final ClientConfigProperties configProperties;
    private static final String APP_ID = "&appid=8f472c70733460dde96a4490ebc9aa01";


    @Override
    public Mono<WeatherAllResponseDto> execute(String city) {
        var params = "?q=" + city + APP_ID;
        return WebClient.create()
                .get()
                .uri(configProperties.getOpenWeatherUrl() + params)
                .header(HttpHeaders.ACCEPT, MediaType.APPLICATION_JSON_VALUE)
                .header(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
                .retrieve()
                .bodyToMono(WeatherAllResponseDto.class)
                .onErrorMap(e -> new ErrorInCallToApiException("Error during call in API" + e.getMessage()));
    }
}
