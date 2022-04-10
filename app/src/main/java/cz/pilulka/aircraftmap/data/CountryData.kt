package cz.pilulka.aircraftmap.data

import cz.pilulka.aircraftmap.features.countries.database.CountryEntity

data class CountryData(
    val name: String,
    val minLatitude: Double,
    val maxLatitude: Double,
    val minLongitude: Double,
    val maxLongitude: Double
)

fun CountryData.toEntity(): CountryEntity {
    return CountryEntity(name, minLatitude, maxLatitude, minLongitude, maxLongitude)
}