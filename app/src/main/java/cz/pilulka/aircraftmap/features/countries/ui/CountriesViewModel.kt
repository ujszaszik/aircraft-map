package cz.pilulka.aircraftmap.features.countries.ui

import androidx.lifecycle.ViewModel
import cz.pilulka.aircraftmap.coroutines.launch
import cz.pilulka.aircraftmap.coroutines.mutableStateFlow
import cz.pilulka.aircraftmap.features.countries.database.toModel
import cz.pilulka.aircraftmap.features.countries.model.CountryModel
import cz.pilulka.aircraftmap.features.countries.repository.CountriesRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.collect
import javax.inject.Inject

@HiltViewModel
class CountriesViewModel @Inject constructor(
    private val repository: CountriesRepository
) : ViewModel() {

    private var allCountries = listOf<CountryModel>()
    private var listedCountries = listOf<CountryModel>()

    private val _countries = mutableStateFlow<List<CountryModel>>()
    val countries: StateFlow<List<CountryModel>?> = _countries

    init {
        launch {
            repository.listAll().collect { entities ->
                allCountries = entities.map { it.toModel() }
                listedCountries = allCountries
                _countries.emit(listedCountries)
            }
        }
    }

    internal fun onCountrySearch(keyword: String) {
        launch {
            listedCountries = when {
                keyword.isEmpty() -> allCountries
                else -> allCountries.filter { it.name.contains(keyword, ignoreCase = true) }
            }
            _countries.emit(listedCountries)
        }
    }

    internal fun resetSearch() = launch { _countries.emit(allCountries) }
}