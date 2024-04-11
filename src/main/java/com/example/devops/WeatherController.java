package com.example.devops;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.springframework.stereotype.Service;

@RestController
public class WeatherController {
    private WeatherService weatherService;

    @GetMapping("/weather")
    public String getWeather(@RequestParam String LAT, @RequestParam String LONG) {
        // latitude = "48.788776871408054";
        // longitude = "2.3637585999999997";
        this.weatherService = new WeatherService();
        return weatherService.getWeather(LAT, LONG);
    }
}
