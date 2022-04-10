package cz.pilulka.aircraftmap.features.countries.database

import androidx.room.Entity
import androidx.room.PrimaryKey
import cz.pilulka.aircraftmap.features.countries.model.CountryModel

@Entity(tableName = "countries")
data class CountryEntity(
    @PrimaryKey val name: String,
    val minLatitude: Double,
    val maxLatitude: Double,
    val minLongitude: Double,
    val maxLongitude: Double
)

fun CountryEntity.toModel(): CountryModel {
    return CountryModel(
        name = name,
        minLatitude = minLatitude,
        maxLatitude = maxLatitude,
        minLongitude = minLongitude,
        maxLongitude = maxLongitude
    )
}