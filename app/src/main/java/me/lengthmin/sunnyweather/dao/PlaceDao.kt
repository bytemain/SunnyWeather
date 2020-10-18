package me.lengthmin.sunnyweather.dao

import android.content.Context
import androidx.core.content.edit
import com.google.gson.Gson
import me.lengthmin.sunnyweather.SunnyWeatherApplication
import me.lengthmin.sunnyweather.model.PlaceResponse

object PlaceDao {
    private fun sharedPreferences() =
        SunnyWeatherApplication.context.getSharedPreferences("Configuration", Context.MODE_PRIVATE)

    fun savePlace(place: PlaceResponse.Place) {
        sharedPreferences().edit {
            putString("place", Gson().toJson(place))
        }
    }

    fun getSavedPlace(): PlaceResponse.Place {
        val placeJson = sharedPreferences().getString("place", "")
        return Gson().fromJson(placeJson, PlaceResponse.Place::class.java)
    }

    fun isPlaceSaved() = sharedPreferences().contains("place")
}