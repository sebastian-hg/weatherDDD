package com.accuweather.weather.core.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class City {
    private Long id;
    private String name;
    private Country country;
    private WeatherCondition weatherCondition;
}
