package com.accuweather.weather.api.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class WeatherAllResponseDto {
    Coord coord;
    Weather weather;
    String base;
    Main main;
    Integer visibility;
    Wind wind;
    Clouds clouds;
    Integer dt;
    Sys sys;
    Integer timeZone;
    Long id;
    String name;
    Integer cod;
}
