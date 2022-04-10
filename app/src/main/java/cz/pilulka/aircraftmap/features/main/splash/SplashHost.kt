package cz.pilulka.aircraftmap.features.main.splash

import androidx.compose.runtime.Composable
import androidx.compose.runtime.livedata.observeAsState
import androidx.hilt.navigation.compose.hiltViewModel
import cz.pilulka.aircraftmap.features.countries.ui.CountriesHost
import cz.pilulka.aircraftmap.navigation.graph.LocalNavController
import cz.pilulka.aircraftmap.navigation.host.Host

val SplashHost = Host(route = "SplashHost")

@Composable
fun SplashHost(viewModel: SplashViewModel = hiltViewModel()) {

    val isSplashFinished = viewModel.isSplashFinished.observeAsState().value ?: false

    if (isSplashFinished) {
        LocalNavController.current.navigate(CountriesHost.route)
    }

    SplashScreen()
}