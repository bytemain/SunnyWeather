package me.lengthmin.sunnyweather.model

import com.google.gson.annotations.SerializedName

data class PlaceResponse(val status: String, val places: List<Place>)

data class Place(
    @SerializedName("place_id") val placeId: String,
    val location: Location,
    val name: String,
    @SerializedName("formatted_address") val formattedAddress: String
)

data class Location(val lat: Float, val lng: Float)