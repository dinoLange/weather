package com.example.demo.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class WeatherEntry(
    @SerialName("dateTime") val dateTime: String,
    @SerialName("temp") val temp: Double? = null,
    @SerialName("tempMean") val tempMean: Double? = null,
    @SerialName("tempMin") val tempMin: Double? = null,
    @SerialName("tempMax") val tempMax: Double? = null,
    @SerialName("dewpointMean") val dewpointMean: Double? = null,
    @SerialName("precSum") val precSum: Double? = null,
    @SerialName("temp5cmMin") val temp5cmMin: Double? = null,
    @SerialName("windSpeedMean") val windSpeedMean: Double? = null,
    @SerialName("windSpeedMax") val windSpeedMax: Double? = null,
    @SerialName("windGustMax") val windGustMax: Double? = null,
    @SerialName("windDirectionMean") val windDirectionMean: Double? = null,
    @SerialName("humidityRelativeMean") val humidityRelativeMean: Double? = null
)