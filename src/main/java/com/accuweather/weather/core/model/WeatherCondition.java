package com.accuweather.weather.core.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;


@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class WeatherCondition {
    private Long id;
    private Double temperature;
    private Double wind;
    private Double humidity;
    private LocalDateTime time;
}
