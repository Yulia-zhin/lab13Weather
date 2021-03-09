package com.zhin.lab13weather.common

import com.zhin.lab13weather.retrofit.RetrofitClient
import com.zhin.lab13weather.retrofit.RetrofitServices

object Common {
    private val BASE_URL_MOVIE = "https://www.simplifiedcoding.net/demos/"
    val retrofitServiceMovie: RetrofitServices
        get() = RetrofitClient.getClient(BASE_URL_MOVIE).create(RetrofitServices::class.java)

    private val BASE_URL_WEATHER= "http://api.openweathermap.org/"
    val retrofitServiceWeather: RetrofitServices
        get() = RetrofitClient.getClient(BASE_URL_WEATHER).create(RetrofitServices::class.java)
}