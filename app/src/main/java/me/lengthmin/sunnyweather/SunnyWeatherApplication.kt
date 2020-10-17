package me.lengthmin.sunnyweather

import android.app.Application
import android.content.Context

class SunnyWeatherApplication: Application() {
    companion object {
        lateinit var context: Context
        // CaiYun Token
        const val CYTOKEN = "jCB4JnCEqMnyK41Q"
    }

    override fun onCreate() {
        super.onCreate()
        context = applicationContext
    }
}