package cz.pilulka.aircraftmap.features.countries.database

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query

@Dao
interface CountriesDao {

    @Query("SELECT * FROM countries ORDER BY name")
    fun getCountriesList(): List<CountryEntity>

    @Query("SELECT COUNT(*) FROM countries")
    fun getCountriesCount(): Int

    @Insert
    suspend fun insertCountries(countries: List<CountryEntity>)

}