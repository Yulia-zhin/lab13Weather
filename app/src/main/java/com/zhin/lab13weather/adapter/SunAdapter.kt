package com.zhin.lab13weather.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.zhin.lab13weather.R
import com.zhin.lab13weather.model.SunInfo
import com.zhin.lab13weather.model.WeatherInfo
import kotlinx.android.synthetic.main.item_sun_layout.view.*
import kotlinx.android.synthetic.main.item_sun_layout.view.idCountry
import kotlinx.android.synthetic.main.item_weather_layout.view.*

class SunAdapter(private val context: Context, private val sunList: MutableList<SunInfo>):
    RecyclerView.Adapter<SunAdapter.MyViewHolder>() {

    class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val txt_country: TextView = itemView.idCountry
        val txt_sunrise: TextView = itemView.idSunrise
        val txt_sunset: TextView = itemView.idSunset

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val itemView =
            LayoutInflater.from(parent.context).inflate(R.layout.item_sun_layout, parent, false)
        return MyViewHolder(itemView)
    }

    override fun getItemCount() = sunList.size

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.txt_country.text = sunList[position].country_
        holder.txt_sunrise.text = sunList[position].sunrise_
        holder.txt_sunset.text = sunList[position].sunset_

    }
}