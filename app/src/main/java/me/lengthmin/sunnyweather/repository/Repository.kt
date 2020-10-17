package me.lengthmin.sunnyweather.repository

import androidx.lifecycle.liveData
import kotlinx.coroutines.Dispatchers
import me.lengthmin.sunnyweather.network.Network
import java.lang.Exception
import java.lang.RuntimeException

object Repository {
    fun searchPlaces(query: String) = liveData(Dispatchers.IO) {
        val result = try {
            val placeResponse = Network.searchPlaces(query)
            if (placeResponse.status == "ok") {
                Result.success(placeResponse.places)
            } else {
                Result.failure(RuntimeException("Get places is wrong, status code is ${placeResponse.status}"))
            }
        } catch (e: Exception) {
            Result.failure(e)
        }
        emit(result)
    }
}