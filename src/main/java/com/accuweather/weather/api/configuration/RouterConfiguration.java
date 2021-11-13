package com.accuweather.weather.api.configuration;

import com.accuweather.weather.api.handler.GetWeatherByCityHandler;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.server.RequestPredicates;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.ServerResponse;

import static org.springframework.web.reactive.function.server.RouterFunctions.route;

@Configuration
public class RouterConfiguration {

    @Bean
    public RouterFunction<ServerResponse> routeRequest(GetWeatherByCityHandler getWeatherByCityHandler) {
        return route(RequestPredicates.GET("/weather-by-city"), getWeatherByCityHandler::executeWithoutBodyValidation);
    }

}