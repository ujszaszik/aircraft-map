package dependencies.libs

import dependencies.Dependency
import dependencies.provider.DependencyProvider
import dependencies.values

object MapLibs : DependencyProvider {

    const val VERSION_MAPS_COMPOSE = "1.0.0"
    const val VERSION_GMS = "18.0.2"

    override fun dependencies() = listOf(
        Dependency("com.google.maps.android", "maps-compose", VERSION_MAPS_COMPOSE),
        Dependency("com.google.android.gms", "play-services-maps", VERSION_GMS),
    ).values()

}