package com.zhin.lab13weather.retrofit

import com.zhin.lab13weather.model.Movie
import com.zhin.lab13weather.model.WeatherResponse
import retrofit2.Call
import retrofit2.http.*

interface RetrofitServices {
    @GET("marvel")
    fun getMovieList(): Call<MutableList<Movie>>

    @GET("data/2.5/weather?")
    fun getCurrentWeatherData(@Query("q") q: String, @Query("appid") app_id: String): Call<WeatherResponse>

    @GET("data/2.5/weather?")
    fun getCurrentWeatherDataByCord(@Query("lat") lat: String, @Query("lon") lon: String, @Query("appid") app_id: String): Call<WeatherResponse>
}