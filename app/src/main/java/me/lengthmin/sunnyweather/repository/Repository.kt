package me.lengthmin.sunnyweather.repository

import androidx.lifecycle.liveData
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.async
import kotlinx.coroutines.coroutineScope
import me.lengthmin.sunnyweather.dao.PlaceDao
import me.lengthmin.sunnyweather.model.PlaceResponse
import me.lengthmin.sunnyweather.model.Weather
import me.lengthmin.sunnyweather.network.Network
import java.lang.Exception
import java.lang.RuntimeException
import kotlin.coroutines.CoroutineContext

object Repository {
    private fun <T> fire(
        context: CoroutineContext = Dispatchers.IO,
        block: suspend () -> Result<T>
    ) =
        liveData(context) {
            val result = try {
                block()
            } catch (e: Exception) {
                Result.failure(e)
            }
            emit(result)
        }

    private fun <T> fireSuccess(
        context: CoroutineContext = Dispatchers.Default,
        block: suspend () -> T
    ) =
        fire(context) {
            Result.success(block())
        }

    fun searchPlaces(query: String) = fire {
        val placeResponse = Network.searchPlaces(query)
        if (placeResponse.status == "ok") {
            Result.success(placeResponse.places)
        } else {
            Result.failure(RuntimeException("Get places is wrong, status code is ${placeResponse.status}"))
        }
    }

    fun refreshWeather(lng: String, lat: String) = fire {
        coroutineScope {
            val deferredRealtime = async {
                Network.getRealtimeWeather(lng, lat)
            }
            val deferredDaily = async {
                Network.getDailyWeather(lng, lat)
            }
            val realtimeResponse = deferredRealtime.await()
            val dailyResponse = deferredDaily.await()
            if (realtimeResponse.status == "ok" && dailyResponse.status == "ok") {
                val weather =
                    Weather(realtimeResponse.result.realtime, dailyResponse.result.daily)
                Result.success(weather)
            } else {
                Result.failure(
                    RuntimeException(
                        "realtime response status is ${realtimeResponse.status}\n" +
                                "daily response status is ${dailyResponse.status}"
                    )
                )
            }
        }
    }

    fun savePlace(place: PlaceResponse.Place) = PlaceDao.savePlace(place)

    fun getSavedPlace() = PlaceDao.getSavedPlace()

    fun isPlaceSaved(): Boolean = PlaceDao.isPlaceSaved()
}