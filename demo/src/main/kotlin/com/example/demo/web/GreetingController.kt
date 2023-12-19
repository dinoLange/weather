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

    @PostMapping("/pieChart")
    fun pieChart(model: Model): String {

        model.addAttribute("rows", "[['Mushrooms', 3],['Onions', 1],['Olives', 4],['Zucchini', 1],['Pepperoni', 2]]")
        model.addAttribute("columns", "string: Topping, number: Slices")
        model.addAttribute("title", "My Beautiful Pie Chart")
        return "charts/pieChart"
    }

    @PostMapping("/lineChart")
    fun lineChart(model: Model): String {
        model.addAttribute("rows",
            "[\n" +
                "                  [1,  37.8, 80.8, 41.8],\n" +
                "                  [2,  30.9, 69.5, 32.4],\n" +
                "                  [3,  25.4,   57, 25.7],\n" +
                "                  [4,  11.7, 18.8, 10.5],\n" +
                "                  [5,  11.9, 17.6, 10.4],\n" +
                "                  [6,   8.8, 13.6,  7.7],\n" +
                "                  [7,   7.6, 12.3,  9.6],\n" +
                "                  [8,  12.3, 29.2, 10.6],\n" +
                "                  [9,  16.9, 42.9, 14.8],\n" +
                "                  [10, 12.8, 30.9, 11.6],\n" +
                "                  [11,  5.3,  7.9,  4.7],\n" +
                "                  [12,  6.6,  8.4,  5.2],\n" +
                "                  [13,  4.8,  6.3,  3.6],\n" +
                "                  [14,  4.2,  6.2,  3.4]\n" +
                "                ]")
        model.addAttribute("columns", "number: Day, number: Guardians, number: The Avengers, number: Transformers")
        model.addAttribute("title", "My Beautiful Line Chart")
        return "charts/lineChart"
    }

}
