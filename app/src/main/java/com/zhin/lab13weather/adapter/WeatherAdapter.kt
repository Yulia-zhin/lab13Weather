package com.zhin.lab13weather.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.zhin.lab13weather.R
import com.zhin.lab13weather.model.Movie
import com.zhin.lab13weather.model.WeatherInfo
import com.zhin.lab13weather.model.WeatherResponse
import kotlinx.android.synthetic.main.item_weather_layout.view.*

class WeatherAdapter(private val context: Context, private val weatherList: MutableList<WeatherInfo>):
    RecyclerView.Adapter<WeatherAdapter.ViewHolder>() {

    class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){
        //val txt_country: TextView = itemView.txt_name
        val txt_country: TextView = itemView.idCountry
        val txt_temp_min: TextView = itemView.idTemp_min
        val txt_temp_max: TextView = itemView.idTemp_max
        val txt_humidity: TextView = itemView.idHumidity
        val txt_pressure: TextView = itemView.idPressure

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.item_weather_layout, parent, false)
        return ViewHolder(itemView)
    }

    override fun getItemCount() = weatherList.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.txt_country.text = weatherList[position].country_
        holder.txt_temp_min.text = weatherList[position].temp_min_.toString()
        holder.txt_temp_max.text = weatherList[position].temp_max_.toString()
        holder.txt_humidity.text = weatherList[position].humidity_
        holder.txt_pressure.text = weatherList[position].pressure_
    }

}