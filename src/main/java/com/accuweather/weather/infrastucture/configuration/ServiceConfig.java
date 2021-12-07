package com.accuweather.weather.infrastucture.configuration;

import com.accuweather.weather.core.repository.CityRepository;
import com.accuweather.weather.core.repository.CountryRepository;
import com.accuweather.weather.core.repository.OpenWeatherRepository;
import com.accuweather.weather.core.repository.WeatherConditionsRepository;
import com.accuweather.weather.core.service.GetAllCity;
import com.accuweather.weather.core.service.GetAllCountry;
import com.accuweather.weather.core.service.GetWeatherByCity;
import com.accuweather.weather.core.service.GetWeatherByID;
import com.accuweather.weather.core.service.impl.GetAllCityImpl;
import com.accuweather.weather.core.service.impl.GetAllCountryImpl;
import com.accuweather.weather.core.service.impl.GetWeatherByCityImpl;
import com.accuweather.weather.core.service.impl.GetWeatherByIdImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
public class ServiceConfig {
    @Bean
    GetWeatherByID getWeatherByID(CityRepository cityRepository) {
        return new GetWeatherByIdImpl(cityRepository);
    }

    @Bean
    GetWeatherByCity getWeatherByCity(OpenWeatherRepository openWeatherRepository, CityRepository cityRepository) {
        return new GetWeatherByCityImpl(openWeatherRepository, cityRepository);
    }

    @Bean
    GetAllCountry getAllCountry(CountryRepository countryRepository) {
        return new GetAllCountryImpl(countryRepository);
    }

    @Bean
    GetAllCity getAllCity(CityRepository cityRepository) {
        return new GetAllCityImpl(cityRepository);
    }


}
