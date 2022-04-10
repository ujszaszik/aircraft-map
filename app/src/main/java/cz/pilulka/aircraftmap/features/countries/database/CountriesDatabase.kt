package cz.pilulka.aircraftmap.features.countries.database

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(
    entities = [CountryEntity::class],
    version = 1,
    exportSchema = false
)
abstract class CountriesDatabase : RoomDatabase() {

    abstract fun countriesDao(): CountriesDao
}