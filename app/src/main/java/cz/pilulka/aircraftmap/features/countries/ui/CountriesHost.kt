package cz.pilulka.aircraftmap.features.countries.ui

import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import cz.pilulka.aircraftmap.coroutines.collectAsStateValue
import cz.pilulka.aircraftmap.features.aircraft.ui.AircraftHost
import cz.pilulka.aircraftmap.navigation.graph.LocalNavController
import cz.pilulka.aircraftmap.navigation.host.BackPressStrategy
import cz.pilulka.aircraftmap.navigation.host.Host
import cz.pilulka.aircraftmap.navigation.host.HostType
import cz.pilulka.aircraftmap.navigation.host.withData

val CountriesHost = Host(
    route = "CountriesHost",
    title = "Countries",
    type = HostType.MAIN,
    backPressStrategy = BackPressStrategy.EXIT_APPLICATION
)

@Composable
fun CountriesHost(viewModel: CountriesViewModel = hiltViewModel()) {

    val navController = LocalNavController.current

    val countries = viewModel.countries.collectAsStateValue()

    countries?.let {
        CountriesScreen(
            countries = it,
            onCountryClicked = { country ->
                navController.navigate(AircraftHost.withData(country))
                viewModel.resetSearch()
            },
            onCountrySearch = { keyword -> viewModel.onCountrySearch(keyword) }
        )
    }

}