package cz.pilulka.compose.map

import com.google.android.gms.maps.model.BitmapDescriptorFactory
import com.google.android.gms.maps.model.LatLng

data class MapMarker(
    val position: LatLng,
    val title: String,
    val details: String,
    val isOnGround: Boolean,
    val onClick: (MapMarker) -> Unit = {}
)

val MapMarker.colorDescriptor: Float
    get() = if (isOnGround) BitmapDescriptorFactory.HUE_RED else BitmapDescriptorFactory.HUE_AZURE