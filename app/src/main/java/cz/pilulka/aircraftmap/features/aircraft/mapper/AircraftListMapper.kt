package cz.pilulka.aircraftmap.features.aircraft.mapper

import cz.pilulka.aircraftmap.converter.VelocityConverter
import cz.pilulka.aircraftmap.converter.VelocityUnit
import cz.pilulka.aircraftmap.features.aircraft.model.AircraftListModel
import cz.pilulka.aircraftmap.features.aircraft.model.AircraftModel
import cz.pilulka.aircraftmap.features.aircraft.network.AircraftListResponse
import cz.pilulka.network.mapper.BaseMapper

class AircraftListMapper : BaseMapper<AircraftListResponse, AircraftListModel> {

    override fun map(remote: AircraftListResponse): AircraftListModel {
        return AircraftListModel(remote.states.map { AircraftItemMapper.map(it) })
    }
}

object AircraftItemMapper : BaseMapper<List<Any>, AircraftModel> {

    private val converter = VelocityConverter(VelocityUnit.MPS)

    override fun map(remote: List<Any>): AircraftModel {
        return AircraftModel(
            callSign = remote[1] as? String,
            originalCountry = remote[2].toString(),
            isOnGround = remote[8] as Boolean,
            latitude = remote[6] as? Double,
            longitude = remote[5] as? Double,
            altitude = remote[7] as? Double,
            velocity = converter.convert(remote[9] as? Double)
        )
    }
}