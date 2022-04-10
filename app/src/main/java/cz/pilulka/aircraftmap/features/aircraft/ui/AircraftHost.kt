package cz.pilulka.aircraftmap.features.aircraft.ui

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.hilt.navigation.compose.hiltViewModel
import cz.pilulka.aircraftmap.coroutines.collectAsStateValue
import cz.pilulka.aircraftmap.features.countries.model.CountryModel
import cz.pilulka.aircraftmap.navigation.graph.LocalNavController
import cz.pilulka.aircraftmap.navigation.host.Host
import cz.pilulka.aircraftmap.navigation.host.HostType
import cz.pilulka.aircraftmap.navigation.host.acceptParam

const val COUNTRY_PARAM_KEY = "AircraftHost::CountryParam"

val AircraftHost = Host(
    route = "AircraftHost",
    title = "Aircraft Data",
    type = HostType.SUB
).acceptParam(COUNTRY_PARAM_KEY)

@Composable
fun AircraftHost(country: CountryModel?, viewModel: AircraftViewModel = hiltViewModel()) {

    val navController = LocalNavController.current

    LaunchedEffect(country) {
        country?.let {
            viewModel.startPeriodicalUpdates(it)
        } ?: navController.navigateUp()
    }

    val isLoading = viewModel.isLoading.collectAsStateValue() ?: false
    val hasError = viewModel.hasError.collectAsStateValue() ?: false
    val items = viewModel.aircraftList.collectAsStateValue() ?: emptyList()
    val screenType = viewModel.screenType.collectAsState().value
    val refreshInSeconds = viewModel.refreshInSeconds.collectAsState().value

    AircraftScreen(
        countryName = country?.name,
        screenType = screenType,
        items = items,
        onToggle = { viewModel.toggleScreenType() },
        isLoading = isLoading,
        hasError = hasError,
        onErrorClosed = { navController.popBackStack() },
        refreshInSeconds = refreshInSeconds
    )

}