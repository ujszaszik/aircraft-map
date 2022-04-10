package cz.pilulka.compose.button

import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.vector.ImageVector
import cz.pilulka.compose.resources.Colors

@Composable
fun SecondaryButton(
    label: String,
    icon: ImageVector,
    onClick: () -> Unit
) {
    DefaultButton(
        label = label,
        backgroundColor = Colors.white,
        textColor = Colors.black,
        icon = icon,
        iconTint = Colors.black,
        onClick = onClick
    )
}