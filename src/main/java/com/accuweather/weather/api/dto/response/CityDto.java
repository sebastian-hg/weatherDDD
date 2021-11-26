package com.accuweather.weather.api.dto.response;

import com.accuweather.weather.api.helper.IResponseSuccess;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Builder
@AllArgsConstructor
public class CityDto implements IResponseSuccess {
    private Long idReference;
    private String city;
    private String country;
    private LocalDateTime timeNow;
    private Double temperature;

}
