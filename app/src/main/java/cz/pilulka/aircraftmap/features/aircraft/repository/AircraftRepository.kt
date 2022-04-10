package cz.pilulka.aircraftmap.features.aircraft.repository

import cz.pilulka.aircraftmap.coroutines.ResourceFlow
import cz.pilulka.aircraftmap.features.aircraft.model.AircraftListModel
import cz.pilulka.aircraftmap.features.aircraft.network.AircraftService
import cz.pilulka.aircraftmap.features.countries.model.CountryModel
import cz.pilulka.network.operation.networkFlow
import javax.inject.Inject

class AircraftRepository @Inject constructor(
    private val service: AircraftService
) {

    fun getAircraftList(country: CountryModel): ResourceFlow<AircraftListModel> {
        return networkFlow {
            service.getStateVectors(
                minLatitude = country.minLatitude,
                maxLatitude = country.maxLatitude,
                minLongitude = country.minLongitude,
                maxLongitude = country.maxLongitude
            )
        }
    }
}