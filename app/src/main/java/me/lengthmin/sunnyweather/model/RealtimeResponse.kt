package me.lengthmin.sunnyweather.model


import com.google.gson.annotations.SerializedName

data class RealtimeResponse(
    @SerializedName("api_status")
    val apiStatus: String, // active
    @SerializedName("api_version")
    val apiVersion: String, // v2.5
    val lang: String, // zh_CN
    val location: List<Double>,
    val result: Result,
    @SerializedName("server_time")
    val serverTime: Int, // 1602926246
    val status: String, // ok
    val timezone: String, // Asia/Taipei
    val tzshift: Int, // 28800
    val unit: String // metric
) {
    data class Result(
        val primary: Int, // 0
        val realtime: Realtime
    ) {
        data class Realtime(
            @SerializedName("air_quality")
            val airQuality: AirQuality,
            @SerializedName("apparent_temperature")
            val apparentTemperature: Double, // 15.8
            val cloudrate: Double, // 0.9
            val dswrf: Double, // 35.3
            val humidity: Double, // 0.68
            @SerializedName("life_index")
            val lifeIndex: LifeIndex,
            val precipitation: Precipitation,
            val pressure: Double, // 100057.49
            val skycon: String, // LIGHT_RAIN
            val status: String, // ok
            val temperature: Double, // 20.16
            val visibility: Double, // 9.24
            val wind: Wind
        ) {
            data class AirQuality(
                val aqi: Aqi,
                val co: Double, // 0.3
                val description: Description,
                val no2: Double, // 0
                val o3: Double, // 0
                val pm10: Double, // 0
                val pm25: Double, // 3
                val so2: Double // 0
            ) {
                data class Aqi(
                    val chn: Double, // 8
                    val usa: Double // 0
                )

                data class Description(
                    val chn: String, // 优
                    val usa: String
                )
            }

            data class LifeIndex(
                val comfort: Comfort,
                val ultraviolet: Ultraviolet
            ) {
                data class Comfort(
                    val desc: String, // 凉爽
                    val index: Int // 6
                )

                data class Ultraviolet(
                    val desc: String, // 无
                    val index: Int // 0
                )
            }

            data class Precipitation(
                val local: Local
            ) {
                data class Local(
                    val datasource: String, // gfs
                    val intensity: Double, // 0.1552
                    val status: String // ok
                )
            }

            data class Wind(
                val direction: Double, // 45.35
                val speed: Double // 31.57
            )
        }
    }
}