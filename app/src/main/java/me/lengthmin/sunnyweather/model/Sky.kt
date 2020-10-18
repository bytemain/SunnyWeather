package me.lengthmin.sunnyweather.model

class Sky(val info: String)

private val sky = mapOf(
    "CLEAR_DAY" to Sky("晴（白天）"),
    "CLEAR_NIGHT" to Sky("晴（夜间）"),
    "PARTLY_CLOUDY_DAY" to Sky("多云（白天）"),
    "PARTLY_CLOUDY_NIGHT" to Sky("多云（夜间）"),
    "CLOUDY" to Sky("阴"),
    "LIGHT_HAZE" to Sky("轻度雾霾"),
    "MODERATE_HAZE" to Sky("中度雾霾"),
    "HEAVY_HAZE" to Sky("重度雾霾"),
    "LIGHT_RAIN" to Sky("小雨"),
    "MODERATE_RAIN" to Sky("中雨"),
    "HEAVY_RAIN" to Sky("大雨"),
    "STORM_RAIN" to Sky("暴雨"),
    "FOG" to Sky("雾"),
    "LIGHT_SNOW" to Sky("小雪"),
    "MODERATE_SNOW" to Sky("中雪"),
    "HEAVY_SNOW" to Sky("大雪"),
    "STORM_SNOW" to Sky("暴雪"),
    "DUST" to Sky("浮尘"),
    "SAND" to Sky("沙尘"),
    "WIND" to Sky("大风"),
    "UNKNOWN" to Sky("未知")
)

fun getSky(skyconValue: String): Sky {
    return sky[skyconValue] ?: Sky(skyconValue)
}