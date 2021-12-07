package com.accuweather.weather.core.model;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Country {
    private Long id;
    private Long idSource;
    private String name;
    private Integer postalCode;
}
