package cz.pilulka.aircraftmap.features.countries.repository

import cz.pilulka.aircraftmap.data.CountryDataFileProcessor
import cz.pilulka.aircraftmap.data.toEntity
import cz.pilulka.aircraftmap.features.countries.database.CountriesDatabase
import cz.pilulka.aircraftmap.features.countries.database.CountryEntity
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import javax.inject.Inject

class CountriesRepository @Inject constructor(
    private val fileProcessor: CountryDataFileProcessor,
    private val database: CountriesDatabase
) {

    suspend fun listAll(): Flow<List<CountryEntity>> =
        flow {
            val dao = database.countriesDao()
            if (dao.getCountriesCount() == 0) {
                val entities = fileProcessor.getElements().map { it.toEntity() }
                dao.insertCountries(entities)
            }
            emit(dao.getCountriesList())
        }.flowOn(Dispatchers.IO)
}