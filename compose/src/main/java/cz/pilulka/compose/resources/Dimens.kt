package cz.pilulka.compose.resources

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

object Dimens {

    // PADDING
    val paddingDouble = 16.dp
    val paddingDefault = 8.dp
    val paddingHalf = 4.dp

    private val paddingDefaultHorizontal = 20.dp
    private val paddingDefaultVertical = 12.dp
    val paddingDefaultValues = PaddingValues(
        start = paddingDefaultHorizontal,
        top = paddingDefaultVertical,
        end = paddingDefaultHorizontal,
        bottom = paddingDefaultVertical
    )

    // CARD
    val cardCornerRadius = 8.dp
    val cardElevation = 6.dp

    // TEXT
    val defaultTextSize = 15.sp
    val highlightTextSize = 16.sp
    val repoTitleTextSize = 20.sp
    val appBarTextSize = 24.sp
    val splashTextSize = 30.sp

    // ICON
    val largerIconSize = 24.dp

    // LOGO
    val aircraftLogoHeight = 150.dp
    val aircraftHubLogoWidth = 100.dp

}