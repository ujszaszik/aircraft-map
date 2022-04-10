package cz.pilulka.aircraftmap.features.countries.ui

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.text.style.TextAlign
import cz.pilulka.aircraftmap.features.countries.model.CountryModel
import cz.pilulka.compose.layout.DoubleSpacer
import cz.pilulka.compose.resources.Colors
import cz.pilulka.compose.resources.Dimens
import cz.pilulka.compose.resources.Fonts

@Composable
fun CountryItemScreen(
    country: CountryModel,
    onClick: (CountryModel) -> Unit,
) {

    Card(
        modifier = Modifier
            .padding(Dimens.paddingHalf)
            .fillMaxWidth(),
        shape = RoundedCornerShape(Dimens.cardCornerRadius),
        elevation = Dimens.cardElevation
    ) {

        Column(modifier = Modifier
            .fillMaxWidth()
            .clip(RoundedCornerShape(Dimens.cardCornerRadius))
            .clickable { onClick(country) }
            .padding(horizontal = Dimens.paddingDefault)
        ) {

            DoubleSpacer()

            Text(
                modifier = Modifier.fillMaxWidth(),
                text = country.name,
                textAlign = TextAlign.Center,
                fontFamily = Fonts.enduranceFamily,
                color = Colors.steelGray,
                fontSize = Dimens.repoTitleTextSize,
            )

            DoubleSpacer()
        }

    }

}