package com.example.demo.service

import org.springframework.context.annotation.Bean
import org.springframework.http.HttpEntity
import org.springframework.http.HttpHeaders
import org.springframework.http.HttpMethod
import org.springframework.http.ResponseEntity
import org.springframework.stereotype.Service
import org.springframework.web.client.RestTemplate

@Service
class WeatherApiService(private val restTemplate: RestTemplate) {

    fun callWeatherApi() {
        val apiUrl = "https://api.kachelmannwetter.com/v02/"

        val headers = HttpHeaders()
        headers.set("X-API-Key", "CY3jLwIBWWeNml_Rh2pWxI7fRVpa9cR_swbt-3INMhDS4OS2hLA_FXcqUiCXG8VBLg0GViyOXKiTw2kiR-MkDeAMVmIXRJkJcXeNJgRkibgrEfoTJ_9vvkSBrroe7kte")

        val requestEntity = HttpEntity<String>(headers);

        val response: ResponseEntity<String> = restTemplate.exchange(apiUrl + "station/VH0568/observations/1d", HttpMethod.GET, requestEntity, String::class.java)
        if (response.statusCode.is2xxSuccessful) {
            val responseBody = response.body
            // Process the response body as needed
            println("Response: $responseBody")
        } else {
            System.err.println("Error: " + response.statusCode)
        }
    }
}
