package com.example.weathertrackr.api

import java.net.URL

class WeatherApiImpl : WeatherApi {
    override fun getWeatherData(city: String, apiKey: String): String {
        val url = "http://api.openweathermap.org/data/2.5/weather?q=$city&appid=$apiKey"

        val response = URL(url).readText()

        return response
    }
}