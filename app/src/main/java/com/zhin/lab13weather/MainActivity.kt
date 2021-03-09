package com.zhin.lab13weather

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun clickGoInfoActivity(view: View) {
        val intent = Intent(this@MainActivity, InfoActivity::class.java)
        startActivity(intent)
    }

    fun clickGoWeatherActivity(view: View) {
        val intent = Intent(this@MainActivity, WeatherActivity::class.java)
        startActivity(intent)
    }

    fun clickGoWeatherCordActivity(view: View) {
        val intent = Intent(this@MainActivity, WeatherByCordActivity::class.java)
        startActivity(intent)
    }

    fun clickGoWeatherSunActivity(view: View) {
        val intent = Intent(this@MainActivity, WeatherSunActivity::class.java)
        startActivity(intent)
    }
}