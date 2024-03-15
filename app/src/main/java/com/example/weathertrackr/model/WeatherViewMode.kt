package com.example.weathertrackr.model

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.example.weathertrackr.data.WeatherData
import com.example.weathertrackr.repository.WeatherRepository

class WeatherViewModel : ViewModel() {
    private val weatherRepository = WeatherRepository()

    fun getWeatherData(city: String): LiveData<WeatherData> {
        return weatherRepository.getWeatherData(city)
    }
}