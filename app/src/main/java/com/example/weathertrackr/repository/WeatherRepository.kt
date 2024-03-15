package com.example.weathertrackr.repository

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.weathertrackr.data.WeatherData

class WeatherRepository {
    private val weatherData = MutableLiveData<WeatherData>()

    fun getWeatherData(city: String): LiveData<WeatherData> {
        // Здесь происходит запрос данных о погоде с сервера
        // и обновление LiveData с полученными данными
        return weatherData
    }
}