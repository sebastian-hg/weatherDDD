package com.accuweather.weather.api.exception.api;

import com.accuweather.weather.core.exception.ApiException;
import org.springframework.web.bind.annotation.ResponseStatus;

import static org.springframework.http.HttpStatus.CONFLICT;

@ResponseStatus(value = CONFLICT, reason = ConflictException.MESSAGE)
public class ConflictException extends ApiException {
    public static final transient String MESSAGE = "Business error.";
    private static final long serialVersionUID = -6563942592471632339L;

    public ConflictException() {
        super();
    }

    public ConflictException(String message) {
        super(message);
    }

    public ConflictException(String message, Throwable cause) {
        super(message, cause);
    }

    public ConflictException(Throwable cause) {
        super(cause);
    }

}
