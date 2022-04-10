package cz.pilulka.aircraftmap.navigation.graph

import androidx.compose.runtime.Composable
import androidx.compose.runtime.compositionLocalOf
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import cz.pilulka.aircraftmap.features.aircraft.ui.AircraftHost
import cz.pilulka.aircraftmap.features.aircraft.ui.COUNTRY_PARAM_KEY
import cz.pilulka.aircraftmap.features.countries.model.CountryModel
import cz.pilulka.aircraftmap.features.countries.ui.CountriesHost
import cz.pilulka.aircraftmap.features.main.splash.SplashHost
import cz.pilulka.aircraftmap.navigation.arguments.retainParam
import cz.pilulka.aircraftmap.navigation.composable

val LocalNavController =
    compositionLocalOf<NavHostController> { error("LocalComposition NavController not present") }

@Composable
fun ApplicationGraph() {

    val navController = LocalNavController.current

    NavHost(navController = navController, startDestination = SplashHost.route) {

        composable(SplashHost) {
            SplashHost()
        }

        composable(CountriesHost) {
            CountriesHost()
        }

        composable(AircraftHost) {
            val country = it.retainParam<CountryModel>(COUNTRY_PARAM_KEY)
            AircraftHost(country)
        }

    }
}