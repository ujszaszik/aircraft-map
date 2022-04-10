package cz.pilulka.aircraftmap.features.aircraft

import cz.pilulka.aircraftmap.features.aircraft.network.AircraftService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AircraftModule {

    @Provides
    @Singleton
    fun provideAircraftService(retrofit: Retrofit): AircraftService {
        return retrofit.create(AircraftService::class.java)
    }

}