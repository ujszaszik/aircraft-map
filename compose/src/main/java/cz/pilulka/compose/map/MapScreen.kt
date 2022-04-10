package cz.pilulka.compose.map

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.google.android.gms.maps.model.BitmapDescriptorFactory
import com.google.android.gms.maps.model.CameraPosition
import com.google.maps.android.compose.GoogleMap
import com.google.maps.android.compose.MapUiSettings
import com.google.maps.android.compose.Marker
import com.google.maps.android.compose.rememberCameraPositionState

@Composable
fun MapScreen(markers: List<MapMarker>) {
    val cameraPositionState = rememberCameraPositionState {
        position = CameraPosition.fromLatLngZoom(markers[0].position, 5f)
    }

    GoogleMap(
        modifier = Modifier.fillMaxSize(),
        uiSettings = MapUiSettings().copy(zoomControlsEnabled = false),
        cameraPositionState = cameraPositionState
    ) {

        markers.forEach { marker ->
            Marker(
                icon = BitmapDescriptorFactory.defaultMarker(marker.colorDescriptor),
                position = marker.position,
                title = marker.title,
                snippet = marker.details,
                onClick = {
                    marker.onClick(marker)
                    false
                }
            )
        }
    }
}