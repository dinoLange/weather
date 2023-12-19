package com.example.demo.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class WeatherData(
    @SerialName("stationId") val stationId: String,
    @SerialName("name") val name: String,
    @SerialName("lat") val lat: Double,
    @SerialName("lon") val lon: Double,
    @SerialName("ele") val ele: Int,
    @SerialName("data") val data: List<WeatherEntry>
)