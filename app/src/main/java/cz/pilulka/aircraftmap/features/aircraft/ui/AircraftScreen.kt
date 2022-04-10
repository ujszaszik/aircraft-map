package cz.pilulka.aircraftmap.features.aircraft.ui

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.FloatingActionButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import cz.pilulka.aircraftmap.features.aircraft.model.AircraftModel
import cz.pilulka.aircraftmap.features.aircraft.ui.list.AircraftListScreen
import cz.pilulka.aircraftmap.features.aircraft.ui.map.AircraftMapScreen
import cz.pilulka.compose.dialog.ErrorDialog
import cz.pilulka.compose.layout.TopCenterColumn
import cz.pilulka.compose.resources.Colors
import cz.pilulka.compose.resources.Dimens
import cz.pilulka.compose.resources.Strings

@Composable
fun AircraftScreen(
    countryName: String?,
    screenType: AircraftScreenType,
    items: List<AircraftModel>,
    onToggle: () -> Unit,
    isLoading: Boolean,
    hasError: Boolean,
    onErrorClosed: () -> Unit,
    refreshInSeconds: Long
) {

    Box(modifier = Modifier.fillMaxSize()) {

        TopCenterColumn {
            AircraftResultsHeader(countryName, refreshInSeconds)

            when (screenType) {
                AircraftScreenType.MAP -> AircraftMapScreen(items, isLoading)
                AircraftScreenType.LIST -> AircraftListScreen(items)
            }
        }

        FloatingActionButton(
            modifier = Modifier
                .align(Alignment.BottomEnd)
                .padding(Dimens.paddingDefaultValues),
            backgroundColor = Colors.blue,
            onClick = { onToggle() })
        { screenType.toggleIcon() }
    }

    if (hasError) {
        ErrorDialog(
            title = Strings.ERROR,
            message = AircraftTexts.NO_DATA_AVAILABLE,
            onClosed = { onErrorClosed() }
        )
    }

}