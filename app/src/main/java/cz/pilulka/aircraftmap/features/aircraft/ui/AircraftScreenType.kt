package cz.pilulka.aircraftmap.features.aircraft.ui

import androidx.compose.runtime.Composable
import cz.pilulka.compose.resources.Icons

enum class AircraftScreenType(val toggleIcon: @Composable () -> Unit) {
    LIST({ Icons.MapIcon() }),
    MAP({ Icons.ListIcon() });

    fun toggle(): AircraftScreenType {
        return when (this) {
            LIST -> MAP
            MAP -> LIST
        }
    }
}