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
    Long id;
    String name;
    Country country;
    WeatherCondition weatherCondition;
}
