package me.lengthmin.sunnyweather.ui.weather

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Transformations
import androidx.lifecycle.ViewModel
import me.lengthmin.sunnyweather.model.Location
import me.lengthmin.sunnyweather.model.PlaceResponse
import me.lengthmin.sunnyweather.repository.Repository

class WeatherViewModel : ViewModel() {
    companion object {
        val TAG = "WeatherViewModel"
    }

    private val locationLiveData = MutableLiveData<Location>()
    var locationLng = ""
    var locationLat = ""
    var placeName = ""
    val weatherLiveData = Transformations.switchMap(locationLiveData) {
        Log.i(TAG, "lng: ${it.lng}, lat: ${it.lat}")
        Repository.refreshWeather(it.lng, it.lat)
    }

    fun refreshWeather() {
        locationLiveData.value = Location(lng = this.locationLng, lat = this.locationLat)
    }
}