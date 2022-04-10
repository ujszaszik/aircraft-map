package cz.pilulka.aircraftmap.features.aircraft.ui.map

import androidx.compose.runtime.Composable
import com.google.android.gms.maps.model.LatLng
import cz.pilulka.aircraftmap.features.aircraft.model.AircraftModel
import cz.pilulka.aircraftmap.features.aircraft.model.coordinatesText
import cz.pilulka.aircraftmap.features.aircraft.model.hasCoordinates
import cz.pilulka.aircraftmap.features.aircraft.model.name
import cz.pilulka.compose.layout.LoadingBox
import cz.pilulka.compose.layout.ProgressType
import cz.pilulka.compose.map.MapMarker
import cz.pilulka.compose.map.MapScreen

@Composable
fun AircraftMapScreen(
    items: List<AircraftModel>,
    isLoading: Boolean
) {

    val markers = items
        .filter { it.hasCoordinates }
        .map {
            MapMarker(
                position = LatLng(it.latitude!!, it.longitude!!),
                title = it.name,
                details = it.coordinatesText,
                isOnGround = it.isOnGround
            )
        }

    LoadingBox(isLoading = isLoading, type = ProgressType.ABOVE_SCREEN) {
        if (markers.isNotEmpty()) MapScreen(markers)
    }

}