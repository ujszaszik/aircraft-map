package cz.pilulka.aircraftmap.features.aircraft.ui.list

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import cz.pilulka.aircraftmap.features.aircraft.model.*
import cz.pilulka.compose.layout.TopCenterColumn
import cz.pilulka.compose.resources.Dimens

@Composable
fun AircraftListItemScreen(aircraft: AircraftModel) {

    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(Dimens.paddingDefault),
        elevation = Dimens.cardElevation,
        shape = RoundedCornerShape(Dimens.cardCornerRadius)
    ) {

        TopCenterColumn(modifier = Modifier.padding(Dimens.paddingDefault)) {

            Text(
                modifier = Modifier.fillMaxWidth(),
                text = aircraft.headerText,
                textAlign = TextAlign.Start,
                fontSize = Dimens.highlightTextSize,
                fontWeight = FontWeight.Bold
            )

            Text(
                modifier = Modifier.fillMaxWidth(),
                text = aircraft.latitudeText,
                textAlign = TextAlign.Start,
                fontSize = Dimens.defaultTextSize
            )

            Text(
                modifier = Modifier.fillMaxWidth(),
                text = aircraft.longitudeText,
                textAlign = TextAlign.Start,
                fontSize = Dimens.defaultTextSize
            )

            Text(
                modifier = Modifier.fillMaxWidth(),
                text = aircraft.altitudeText,
                textAlign = TextAlign.Start,
                fontSize = Dimens.defaultTextSize
            )

            Text(
                modifier = Modifier.fillMaxWidth(),
                text = aircraft.velocityText,
                textAlign = TextAlign.Start,
                fontSize = Dimens.defaultTextSize
            )
        }
    }

}