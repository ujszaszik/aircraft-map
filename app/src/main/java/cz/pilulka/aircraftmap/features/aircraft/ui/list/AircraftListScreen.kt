package cz.pilulka.aircraftmap.features.aircraft.ui.list

import androidx.compose.runtime.Composable
import cz.pilulka.aircraftmap.features.aircraft.model.AircraftModel
import cz.pilulka.compose.layout.DefaultSpacer
import cz.pilulka.compose.layout.TopCenterColumn
import cz.pilulka.compose.paging.PagingColumn

@Composable
fun AircraftListScreen(items: List<AircraftModel>) {

    TopCenterColumn {

        DefaultSpacer()

        PagingColumn(
            items = items,
            itemContent = { aircraft, _ -> AircraftListItemScreen(aircraft) })
    }

}