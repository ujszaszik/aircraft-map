package cz.pilulka.aircraftmap.features.aircraft.ui

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import cz.pilulka.compose.resources.Dimens

@Composable
fun AircraftResultsHeader(
    countryName: String?,
    refreshInSeconds: Long
) {

    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(
                top = Dimens.paddingHalf,
                start = Dimens.paddingDouble,
                end = Dimens.paddingDouble
            )
    ) {

        Text(text = AircraftTexts.resultsHeader(countryName))

        Spacer(modifier = Modifier.weight(1f))

        Text(text = AircraftTexts.refreshHeader(refreshInSeconds))
    }
}