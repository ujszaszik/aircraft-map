package cz.pilulka.aircraftmap.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.*
import androidx.navigation.compose.ComposeNavigator
import cz.pilulka.aircraftmap.navigation.host.Host
import cz.pilulka.aircraftmap.navigation.host.compress
import cz.pilulka.aircraftmap.navigation.host.extractHost
import cz.pilulka.aircraftmap.navigation.host.moshi

internal fun NavGraphBuilder.composable(
    host: Host,
    arguments: List<NamedNavArgument> = emptyList(),
    deepLinks: List<NavDeepLink> = emptyList(),
    content: @Composable (NavBackStackEntry) -> Unit
) {
    addDestination(
        ComposeNavigator.Destination(provider[ComposeNavigator::class], content).apply {
            this.label = host.compress()
            this.route = host.route
            arguments.forEach { (argumentName, argument) ->
                addArgument(argumentName, argument)
            }
            deepLinks.forEach { deepLink ->
                addDeepLink(deepLink)
            }
        }
    )
}

internal fun NavController.navigate(
    host: Host,
    navOptions: NavOptions? = null,
    navigatorExtras: Navigator.Extras? = null
) {
    navigate(host.route, navOptions, navigatorExtras)
}

inline fun <reified T> NavController.navigate(host: Host, param: T?) {
    navigate(host.route.plus(moshi.adapter(T::class.java).toJson(param)))
}

fun NavDestination.asHost(): Host? {
    return label.toString().extractHost()
}