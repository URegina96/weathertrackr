package com.example.weathertrackr.repository

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.weathertrackr.api.WeatherApi
import com.example.weathertrackr.data.WeatherData
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class WeatherRepository {
    private val weatherData = MutableLiveData<WeatherData>()

    private val retrofit = Retrofit.Builder()
        .baseUrl("https://api.openweathermap.org/data/2.5/")
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    private val api = retrofit.create(WeatherApi::class.java)

    fun getWeatherData(city: String): LiveData<WeatherData> {
        api.getWeatherData(city, "6bebe24368b8cfdf4394eb82ac12bb19").enqueue(object : Callback<WeatherData> {
            override fun onResponse(call: Call<WeatherData>, response: Response<WeatherData>) {
                if (response.isSuccessful) {
                    weatherData.value = response.body()
                } else {
                    // Обработка ошибки
                }
            }

            override fun onFailure(call: Call<WeatherData>, t: Throwable) {
                // Обработка ошибки
            }
        })

        return weatherData
    }
}