package cz.pilulka.aircraftmap.features.aircraft.network

import com.squareup.moshi.JsonClass
import cz.pilulka.aircraftmap.features.aircraft.mapper.AircraftListMapper
import cz.pilulka.network.mapper.DataMapper

@DataMapper(AircraftListMapper::class)
@JsonClass(generateAdapter = true)
data class AircraftListResponse(
    val time: Int,
    val states: List<List<Any>>
)
