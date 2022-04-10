package cz.pilulka.aircraftmap.features.aircraft.network

import cz.pilulka.aircraftmap.features.aircraft.model.AircraftListModel
import cz.pilulka.network.call.Resource
import retrofit2.http.GET
import retrofit2.http.Query

interface AircraftService {

    @GET("states/all")
    suspend fun getStateVectors(
        @Query("lamin") minLatitude: Double,
        @Query("lamax") maxLatitude: Double,
        @Query("lomin") minLongitude: Double,
        @Query("lomax") maxLongitude: Double,
    ): Resource<AircraftListModel>
}