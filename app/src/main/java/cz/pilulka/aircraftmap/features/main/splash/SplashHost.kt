package cz.pilulka.aircraftmap.features.main.splash

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.hilt.navigation.compose.hiltViewModel
import cz.pilulka.aircraftmap.coroutines.collectAsStateValue
import cz.pilulka.aircraftmap.features.countries.ui.CountriesHost
import cz.pilulka.aircraftmap.navigation.graph.LocalNavController
import cz.pilulka.aircraftmap.navigation.host.Host

val SplashHost = Host(route = "SplashHost")

@Composable
fun SplashHost(viewModel: SplashViewModel = hiltViewModel()) {

    val navController = LocalNavController.current

    val isSplashFinished = viewModel.isSplashFinished.collectAsStateValue() ?: false

    LaunchedEffect(isSplashFinished) {
        if (isSplashFinished) navController.navigate(CountriesHost.route)
    }

    SplashScreen()
}