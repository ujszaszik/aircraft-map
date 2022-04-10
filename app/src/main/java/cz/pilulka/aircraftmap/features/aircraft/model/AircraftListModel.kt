package cz.pilulka.aircraftmap.features.aircraft.model

import cz.pilulka.aircraftmap.features.aircraft.network.AircraftListResponse
import cz.pilulka.extension.*
import cz.pilulka.network.mapper.DataMappedFrom
import kotlin.math.roundToInt

@DataMappedFrom(AircraftListResponse::class)
data class AircraftListModel(
    val items: List<AircraftModel>
)

data class AircraftModel(
    val callSign: String?,
    val originalCountry: String,
    val isOnGround: Boolean,
    val longitude: Double?,
    val latitude: Double?,
    val altitude: Double?,
    val velocity: Double?
)

val AircraftModel.hasCoordinates: Boolean
    get() = longitude != null && latitude != null

val AircraftModel.name: String
    get() = callSign ?: String.notAvailable

val AircraftModel.coordinatesText: String
    get() = "$latitude, $longitude"

val AircraftModel.headerText: String
    get() = "${callSign ?: String.notAvailable} (${originalCountry})"

val AircraftModel.latitudeText: String
    get() = "Latitude: ${latitude.formattedValue(Char.degrees)}"

val AircraftModel.longitudeText: String
    get() = "Longitude: ${longitude.formattedValue(Char.degrees)}"

val AircraftModel.altitudeText: String
    get() = "Altitude: ${altitude.formattedValue(Char.meters)}"

val AircraftModel.velocityText: String
    get() = "Velocity: ${velocity?.roundToInt().formattedValue(String.kmPerHour)}"