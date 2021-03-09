package com.zhin.lab13weather.model

class WeatherInfo(country: String, temperature_min: Float, temperature_max: Float, humidity: String, pressure: String) {
    val country_ = country;
    val temp_min_ = temperature_min.toInt()
    val temp_max_ = temperature_max.toInt()
    val humidity_ = humidity;
    val pressure_ = pressure;
}