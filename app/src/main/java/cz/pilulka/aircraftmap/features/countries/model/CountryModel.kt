package cz.pilulka.aircraftmap.features.countries.model

import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class CountryModel(
    val name: String,
    val minLatitude: Double,
    val maxLatitude: Double,
    val minLongitude: Double,
    val maxLongitude: Double
)