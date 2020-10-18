package me.lengthmin.sunnyweather.model


import com.google.gson.annotations.SerializedName

data class PlaceResponse(
    val places: List<Place>,
    val query: String, // 南京
    val status: String // ok
) {
    data class Place(
        @SerializedName("formatted_address")
        val formattedAddress: String, // 中国江苏省南京市
        val id: String, // ChIJg82NZpuMtTURBhvfeQu2-48
        val location: Location,
        val name: String, // 南京市
        @SerializedName("place_id")
        val placeId: String // g-ChIJg82NZpuMtTURBhvfeQu2-48
    )
}

data class Location(
    val lng: String, // 118.796877
    val lat: String // 32.060255
)