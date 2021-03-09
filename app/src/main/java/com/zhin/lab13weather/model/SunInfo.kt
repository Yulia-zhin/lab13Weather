package com.zhin.lab13weather.model

import java.lang.System.currentTimeMillis
import java.text.SimpleDateFormat
import java.util.*

class SunInfo(country: String, sunrise: String, sunset: String) {
    var sunriseTime: Date = Date((sunrise+"000").toLong())
    var sunriseFormatter: SimpleDateFormat = SimpleDateFormat("HH:mm:ss")
    var sunrise_: String = sunriseFormatter.format(sunriseTime)
    var sunsetTime: Date = Date((sunset+"000").toLong())
    var sunsetFormatter: SimpleDateFormat = SimpleDateFormat("HH:mm:ss")
    var sunset_: String = sunsetFormatter.format(sunsetTime)
    val country_ = country;
}