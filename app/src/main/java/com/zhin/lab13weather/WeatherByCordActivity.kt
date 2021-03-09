package com.zhin.lab13weather


import android.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.zhin.lab13weather.adapter.WeatherAdapter
import com.zhin.lab13weather.common.Common
import com.zhin.lab13weather.model.WeatherInfo
import com.zhin.lab13weather.model.WeatherResponse
import com.zhin.lab13weather.retrofit.RetrofitServices
import kotlinx.android.synthetic.main.activity_weather.*
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class WeatherByCordActivity : AppCompatActivity() {


    private var weatherLon: EditText? = null
    private var weatherLat: EditText? = null
    private lateinit var lon: String;
    private lateinit var lat: String;

    lateinit var mService: RetrofitServices
    lateinit var layoutManager: LinearLayoutManager
    lateinit var adapter: WeatherAdapter

    val mutableList: MutableList<WeatherInfo> =
        mutableListOf<WeatherInfo>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_weather_by_cord)

        mService = Common.retrofitServiceWeather
        recyclerWeatherList.setHasFixedSize(true)
        layoutManager = LinearLayoutManager(this)
        recyclerWeatherList.layoutManager = layoutManager
        weatherLon = findViewById(R.id.lonIdEditText)
        weatherLat = findViewById(R.id.latEditText)
    }

    fun clickSetWeatherCity(view: View) = runBlocking {
        lat = weatherLat!!.text.toString()
        lon = weatherLon!!.text.toString()
        val job =  launch {
            getAllWeatherList(lon, lat)
            val toast = Toast.makeText(applicationContext, "Url is downloaded", Toast.LENGTH_SHORT)
            toast.show()
        }
        job.join()
    }

    private fun getAllWeatherList(lon: String, lat: String) {

        val call = mService.getCurrentWeatherDataByCord(lat, lon, "886705b4c1182eb1c69f28eb8c520e20")
        call.enqueue(object : Callback<WeatherResponse>{
            override fun onResponse(
                call: Call<WeatherResponse>,
                response: Response<WeatherResponse>
            ) {
                if (response.code() == 200) {
                    val weatherResponse = response.body()!!
                    var weatherInfo = WeatherInfo((weatherResponse.sys!!.country).toString(),
                        weatherResponse.main!!.temp_min - 273,
                        weatherResponse.main!!.temp_max - 273,
                        weatherResponse.main!!.humidity.toString(),
                        weatherResponse.main!!.pressure.toString()
                    )
                      mutableList.add(0, weatherInfo)
                    adapter = WeatherAdapter(baseContext, mutableList)

                    adapter.notifyDataSetChanged()
                    recyclerWeatherList.adapter = adapter
                }
            }
            override fun onFailure(call: Call<WeatherResponse>, t: Throwable) {

            }
        })
    }

}