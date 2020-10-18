package me.lengthmin.sunnyweather.model


import com.google.gson.annotations.SerializedName
import java.util.*

data class DailyResponse(
    @SerializedName("api_status")
    val apiStatus: String, // active
    @SerializedName("api_version")
    val apiVersion: String, // v2.5
    val lang: String, // zh_CN
    val location: List<Double>,
    val result: Result,
    @SerializedName("server_time")
    val serverTime: Int, // 1602924582
    val status: String, // ok
    val timezone: String, // Asia/Taipei
    val tzshift: Int, // 28800
    val unit: String // metric
) {
    data class Result(
        val daily: Daily,
        val primary: Int // 0
    ) {
        data class Daily(
            @SerializedName("air_quality")
            val airQuality: AirQuality,
            val astro: List<Astro>,
            val cloudrate: List<Cloudrate>,
            val dswrf: List<Dswrf>,
            val humidity: List<Humidity>,
            @SerializedName("life_index")
            val lifeIndex: LifeIndex,
            val precipitation: List<Precipitation>,
            val pressure: List<Pressure>,
            val skycon: List<Skycon>,
            val status: String, // ok
            val temperature: List<Temperature>,
            val visibility: List<Visibility>,
            val wind: List<Wind>
        ) {
            data class AirQuality(
                val aqi: List<Aqi>,
                val pm25: List<Pm25>
            ) {
                data class Aqi(
                    val avg: Avg,
                    val date: Date, // 2020-10-17T00:00+08:00
                    val max: Max,
                    val min: Min
                ) {
                    data class Avg(
                        val chn: Double, // 7.75
                        val usa: Double // 7.75
                    )

                    data class Max(
                        val chn: Double, // 14
                        val usa: Double // 14
                    )

                    data class Min(
                        val chn: Double, // 7
                        val usa: Double // 7
                    )
                }

                data class Pm25(
                    val avg: Double, // 4
                    val date: Date, // 2020-10-17T00:00+08:00
                    val max: Double, // 8
                    val min: Double // 3
                )
            }

            data class Astro(
                val date: Date, // 2020-10-17T00:00+08:00
                val sunrise: Sunrise,
                val sunset: Sunset
            ) {
                data class Sunrise(
                    val time: String // 05:52
                )

                data class Sunset(
                    val time: String // 17:24
                )
            }

            data class Cloudrate(
                val avg: Double, // 0.96
                val date: String, // 2020-10-17T00:00+08:00
                val max: Double, // 1
                val min: Double // 0.84
            )

            data class Dswrf(
                val avg: Double, // 17.5
                val date: String, // 2020-10-17T00:00+08:00
                val max: Double, // 312.2
                val min: Double // 0
            )

            data class Humidity(
                val avg: Double, // 0.82
                val date: String, // 2020-10-17T00:00+08:00
                val max: Double, // 0.86
                val min: Double // 0.67
            )

            data class LifeIndex(
                val carWashing: List<CarWashing>,
                val coldRisk: List<ColdRisk>,
                val comfort: List<Comfort>,
                val dressing: List<Dressing>,
                val ultraviolet: List<Ultraviolet>
            ) {
                data class CarWashing(
                    val date: String, // 2020-10-17T00:00+08:00
                    val desc: String, // 较不适宜
                    val index: String // 3
                )

                data class ColdRisk(
                    val date: String, // 2020-10-17T00:00+08:00
                    val desc: String, // 易发
                    val index: String // 3
                )

                data class Comfort(
                    val date: String, // 2020-10-17T00:00+08:00
                    val desc: String, // 温暖
                    val index: String // 4
                )

                data class Dressing(
                    val date: String, // 2020-10-17T00:00+08:00
                    val desc: String, // 凉爽
                    val index: String // 5
                )

                data class Ultraviolet(
                    val date: String, // 2020-10-17T00:00+08:00
                    val desc: String, // 最弱
                    val index: String // 1
                )
            }

            data class Precipitation(
                val avg: Double, // 0.1287
                val date: String, // 2020-10-17T00:00+08:00
                val max: Double, // 0.5301
                val min: Double // 0
            )

            data class Pressure(
                val avg: Double, // 100150.95
                val date: String, // 2020-10-17T00:00+08:00
                val max: Double, // 100215.33
                val min: Double // 99975.33
            )

            data class Skycon(
                val date: Date, // 2020-10-17T00:00+08:00
                val value: String // LIGHT_RAIN
            )

            data class Temperature(
                val avg: Double, // 21.9
                val date: Date, // 2020-10-17T00:00+08:00
                val max: Double, // 24
                val min: Double // 21.16
            )

            data class Visibility(
                val avg: Double, // 9.57
                val date: Date, // 2020-10-17T00:00+08:00
                val max: Double, // 24.07
                val min: Double // 9.07
            )

            data class Wind(
                val avg: Avg,
                val date: Date, // 2020-10-17T00:00+08:00
                val max: Max,
                val min: Min
            ) {
                data class Avg(
                    val direction: Double, // 48.96
                    val speed: Double // 28.43
                )

                data class Max(
                    val direction: Double, // 45.35
                    val speed: Double // 31.55
                )

                data class Min(
                    val direction: Double, // 62.95
                    val speed: Double // 24.27
                )
            }
        }
    }
}