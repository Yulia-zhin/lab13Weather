package com.zhin.lab13weather

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.zhin.lab13weather.adapter.SunAdapter
import com.zhin.lab13weather.adapter.WeatherAdapter
import com.zhin.lab13weather.common.Common
import com.zhin.lab13weather.model.SunInfo
import com.zhin.lab13weather.model.WeatherInfo
import com.zhin.lab13weather.model.WeatherResponse
import com.zhin.lab13weather.retrofit.RetrofitServices
import kotlinx.android.synthetic.main.activity_weather.*
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class WeatherSunActivity : AppCompatActivity() {


    private var weatherCityEdit: EditText? = null
    private lateinit var city: String;

    lateinit var mService: RetrofitServices
    lateinit var layoutManager: LinearLayoutManager
    lateinit var adapter: SunAdapter

    val mutableList: MutableList<SunInfo> =
        mutableListOf<SunInfo>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_weather_sun)

        mService = Common.retrofitServiceWeather
        recyclerWeatherList.setHasFixedSize(true)
        layoutManager = LinearLayoutManager(this)
        recyclerWeatherList.layoutManager = layoutManager
        weatherCityEdit = findViewById(R.id.cityIdEditText)
    }

    fun clickSetWeatherCity(view: View) = runBlocking {
        city = weatherCityEdit!!.text.toString()
        val job =  launch {
            getAllWeatherList(city)
            val toast = Toast.makeText(applicationContext, "Url is downloaded", Toast.LENGTH_SHORT)
            toast.show()
        }
        job.join()
    }

    private fun getAllWeatherList(city: String) {

        val call = mService.getCurrentWeatherData(city, "886705b4c1182eb1c69f28eb8c520e20")
        call.enqueue(object : Callback<WeatherResponse>{
            override fun onResponse(
                call: Call<WeatherResponse>,
                response: Response<WeatherResponse>
            ) {
                if (response.code() == 200) {
                    val weatherResponse = response.body()!!
                    var sunInfo = SunInfo((weatherResponse.sys!!.country).toString(),
                        weatherResponse.sys!!.sunrise.toString(),
                        weatherResponse.sys!!.sunset.toString()
                    )
                    mutableList.add(0, sunInfo)
                    adapter = SunAdapter(baseContext, mutableList)

                    adapter.notifyDataSetChanged()
                    recyclerWeatherList.adapter = adapter
                }
            }
            override fun onFailure(call: Call<WeatherResponse>, t: Throwable) {

            }
        })
    }

}