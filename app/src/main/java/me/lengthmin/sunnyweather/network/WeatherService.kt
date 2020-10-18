package me.lengthmin.sunnyweather.network

import me.lengthmin.sunnyweather.SunnyWeatherApplication
import me.lengthmin.sunnyweather.model.DailyResponse
import me.lengthmin.sunnyweather.model.RealtimeResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface WeatherService {
    @GET("/v2.5/${SunnyWeatherApplication.CYTOKEN}/{lng},{lat}/realtime.json")
    fun getRealtimeWeather(
        @Path("lng") lng: String,
        @Path("lat") lat: String
    ): Call<RealtimeResponse>

    @GET("/v2.5/${SunnyWeatherApplication.CYTOKEN}/{lng},{lat}/daily.json")
    fun getDailyWeather(
        @Path("lng") lng: String,
        @Path("lat") lat: String,
        @Query("dailysteps") dailysteps: Int = 10
    ): Call<DailyResponse>
}