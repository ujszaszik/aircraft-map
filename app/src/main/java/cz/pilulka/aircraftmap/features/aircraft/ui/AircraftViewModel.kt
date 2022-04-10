package cz.pilulka.aircraftmap.features.aircraft.ui

import androidx.lifecycle.ViewModel
import cz.pilulka.aircraftmap.coroutines.ResourceFlowMediator
import cz.pilulka.aircraftmap.coroutines.emitValue
import cz.pilulka.aircraftmap.coroutines.launch
import cz.pilulka.aircraftmap.coroutines.mutableStateFlow
import cz.pilulka.aircraftmap.features.aircraft.model.AircraftModel
import cz.pilulka.aircraftmap.features.aircraft.repository.AircraftRepository
import cz.pilulka.aircraftmap.features.countries.model.CountryModel
import cz.pilulka.aircraftmap.timer.PeriodicalTaskManager
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import javax.inject.Inject

@HiltViewModel
class AircraftViewModel @Inject constructor(
    private val repository: AircraftRepository,
    private val periodicalTaskManager: PeriodicalTaskManager
) : ViewModel() {

    private val _isLoading = mutableStateFlow<Boolean>()
    val isLoading: StateFlow<Boolean?> = _isLoading

    private val _hasError = mutableStateFlow<Boolean>()
    val hasError: StateFlow<Boolean?> = _hasError

    private val _aircraftList = mutableStateFlow<List<AircraftModel>>()
    val aircraftList: StateFlow<List<AircraftModel>?> = _aircraftList

    private val _screenType = MutableStateFlow(AircraftScreenType.MAP)
    val screenType: StateFlow<AircraftScreenType> = _screenType

    private val _refreshInSeconds = MutableStateFlow(UPDATE_INTERVAL_IN_SECS)
    val refreshInSeconds: StateFlow<Long> = _refreshInSeconds

    fun startPeriodicalUpdates(country: CountryModel) {
        periodicalTaskManager.startExecuting(
            period = UPDATE_INTERVAL,
            onTicking = { launch { _refreshInSeconds.emit(it) } },
            task = { fetchLatestData(country) }
        )
    }

    private fun fetchLatestData(country: CountryModel) {
        ResourceFlowMediator(
            source = repository.getAircraftList(country),
            viewModel = this,
            loadingFlow = _isLoading,
            onSuccess = { launch { _aircraftList.emit(it.items) } },
            onError = {
                emitValue(_hasError, true)
                periodicalTaskManager.stop()
            }
        ).begin()
    }

    internal fun toggleScreenType() {
        launch { _screenType.emit(_screenType.value.toggle()) }
    }

    companion object {
        private const val UPDATE_INTERVAL = 10000L // ms
        private const val UPDATE_INTERVAL_IN_SECS = 10L
    }
}