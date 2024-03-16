package com.example.weathertrackr.api

import com.example.weathertrackr.data.WeatherData
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface WeatherApi {
    @GET("weather")
    fun getWeatherData(@Query("q") city: String, @Query("appid") apiKey: String): Call<WeatherData>
}