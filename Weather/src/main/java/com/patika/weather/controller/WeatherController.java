package com.patika.weather.controller;



import com.patika.weather.service.WeatherService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/weather")
public class WeatherController {
    private final WeatherService weatherService;

    @GetMapping("/{city}")
    public ResponseEntity<String> getWeather(@PathVariable String city){
        return ResponseEntity.ok().body(weatherService.getWeather(city));
    }



}
