package cz.pilulka.aircraftmap.features.main.splash

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import cz.pilulka.compose.resources.Colors
import cz.pilulka.compose.resources.Dimens
import cz.pilulka.compose.resources.Fonts
import cz.pilulka.compose.resources.Images

@Composable
fun SplashScreen() {
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        Images.AircraftLogo()

        Row {
            Text(
                text = SplashTexts.FROM,
                fontSize = Dimens.splashTextSize,
                color = Colors.steelGray,
                fontFamily = Fonts.pointSoftBoldFamily
            )

            Text(
                text = SplashTexts.COMPANY_NAME,
                fontSize = Dimens.splashTextSize,
                color = Colors.pilulka,
                fontWeight = FontWeight.Bold,
                fontFamily = Fonts.pointSoftBoldFamily
            )
        }
    }
}