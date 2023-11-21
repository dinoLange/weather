package com.example.demo.web

import com.example.demo.model.Greeting
import com.example.demo.service.WeatherApiService
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController
import java.util.concurrent.atomic.AtomicLong


@RestController
class GreetingController(private val weatherApi: WeatherApiService) {

    @GetMapping("/greeting")
    fun greeting(@RequestParam(value = "name", defaultValue = "World") name: String?): String {
        weatherApi.callWeatherApi();
        return "ja moin"
    }

}