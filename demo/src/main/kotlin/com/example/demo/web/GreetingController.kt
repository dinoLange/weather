package com.example.demo.web

import com.example.demo.service.WeatherApiService
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.ui.Model;


@Controller
class MyController(private val weatherApi: WeatherApiService) {


    @GetMapping("/")
    fun index(): String {
        return "index"
    }

    @PostMapping("/furtherInfo")
    fun furtherInfo(model: Model): String {
        //weatherApi.callWeatherApi()
        model.addAttribute("rows", "[['Mushrooms', 3],['Onions', 1],['Olives', 4],['Zucchini', 1],['Pepperoni', 2]]")
        model.addAttribute("columns", "string: Topping, number: Slices")
        return "charts/pieChart"
    }

}
