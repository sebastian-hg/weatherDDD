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
    Long id;
    String name;
    Integer PostalCode; // TODO: AMVP pasar a minúscula
}
