package com.patika.weather.service;


import com.patika.weather.client.WeatherClient;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

@Service
@RequiredArgsConstructor
@Validated
public class WeatherService {


    private final WeatherClient weatherClient;


    public String getWeather(String city){
        return weatherClient.getWeather(city);
    }
}
