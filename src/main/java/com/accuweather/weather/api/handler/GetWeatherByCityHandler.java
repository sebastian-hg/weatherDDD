package com.accuweather.weather.api.handler;

import com.accuweather.weather.api.dto.response.CityDto;
import com.accuweather.weather.api.helper.ResponseHelper;
import com.accuweather.weather.core.service.GetWeatherByCity;
import lombok.NonNull;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Component;
import org.springframework.validation.Validator;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

@Log4j2
@Component
public class GetWeatherByCityHandler extends Handler<Object, Validator> {
    private final GetWeatherByCity getWeatherByCity;

    public GetWeatherByCityHandler(@NonNull ResponseHelper responseHelper,
                                   GetWeatherByCity getWeatherByCity) {
        super(responseHelper);
        this.getWeatherByCity = getWeatherByCity;
    }

    @Override
    protected Mono<ServerResponse> execute(Mono<Object> noBody, ServerRequest serverRequest) {
        var city = serverRequest.queryParam("city").get();
        log.info("Receiving request {}", city);
        return getWeatherByCity.execute(city)
                .flatMap(cityResponse -> {
                    var dto = CityDto.builder().build();
                    return responseHelper.buildOK();
                });
    }
}
