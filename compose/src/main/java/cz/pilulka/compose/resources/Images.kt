package cz.pilulka.compose.resources

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import cz.pilulka.compose.R
import cz.pilulka.extension.empty

object Images {

    @Composable
    fun AircraftLogo() {
        Image(
            painter = painterResource(R.drawable.icon_aircraft),
            modifier = Modifier
                .width(Dimens.aircraftHubLogoWidth)
                .height(Dimens.aircraftLogoHeight),
            contentDescription = String.empty
        )
    }
}