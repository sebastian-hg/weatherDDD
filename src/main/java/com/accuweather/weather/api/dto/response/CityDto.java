package com.accuweather.weather.api.dto.response;

import com.accuweather.weather.api.helper.IResponseSuccess;
import com.accuweather.weather.core.model.City;
import lombok.*;

@Data

@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class CityDto extends City implements IResponseSuccess {
}
