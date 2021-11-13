package com.accuweather.weather.api.exception.client;

import com.accuweather.weather.core.exception.BusinessApiException;
import org.springframework.http.HttpStatus;
import org.springframework.validation.Errors;

public class RequestNotValidException extends BusinessApiException {
    public RequestNotValidException(Errors errors) {
        super("RQ_200", HttpStatus.BAD_REQUEST.value(), "Request Not Valid", errors);
    }


}
