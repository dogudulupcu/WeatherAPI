package com.patika.weather.client;

import lombok.Data;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import javax.validation.constraints.NotBlank;

@Component
@Slf4j
public class WeatherClient {
    private final RestTemplate restTemplate;

    @Value("${api.url}")
    public String apiUrl;

    @Value("${api.key}")
    private String apiKey;

    public WeatherClient() {
        this.restTemplate = new RestTemplate();
    }
   @NotBlank(message = "City name is mandatory")
    public String getWeather(String city){
        String url = apiUrl + "/current.json?key=" + apiKey + "&q=" + city;
        log.info("Requesting weather data from {}", url);
        return restTemplate.getForEntity(url, String.class).getBody();

    }


}
