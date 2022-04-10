package cz.pilulka.compose.dialog

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Cancel
import androidx.compose.material.icons.filled.Done
import androidx.compose.material.icons.filled.Error
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Dialog
import cz.pilulka.compose.button.PrimaryButton
import cz.pilulka.compose.button.SecondaryButton
import cz.pilulka.compose.layout.DoubleSpacer
import cz.pilulka.compose.layout.TopCenterColumn
import cz.pilulka.compose.resources.Colors
import cz.pilulka.compose.resources.Dimens
import cz.pilulka.compose.resources.Strings
import cz.pilulka.extension.empty

@Composable
fun ReposAlertDialog(
    title: String = String.empty,
    description: CharSequence? = null,
    imageVector: ImageVector = Icons.Default.Error,
    isDismissable: Boolean = false,
    onOkay: (() -> Unit)? = null,
    onCancel: (() -> Unit)? = null,
    onDismiss: (() -> Unit)? = null,
    body: @Composable (() -> Unit)? = null,
    style: ReposAlertDialogStyle = ReposAlertDialogStyle()
) {
    val totalScreenWidth = LocalConfiguration.current.screenWidthDp

    Dialog(onDismissRequest = { if (isDismissable) onDismiss?.invoke() }) {
        Card(shape = RoundedCornerShape(style.cornerRadius)) {
            TopCenterColumn(
                modifier = Modifier
                    .padding(style.padding)
                    .width((totalScreenWidth * 0.7).dp)
            ) {

                Icon(
                    modifier = Modifier.size(40.dp),
                    imageVector = imageVector,
                    tint = Colors.red,
                    contentDescription = null
                )

                DoubleSpacer()

                if (title.isNotEmpty()) {
                    Text(
                        text = title,
                        fontSize = Dimens.highlightTextSize
                    )
                }

                Spacer(modifier = Modifier.height(style.spacing))

                description?.let {
                    Text(
                        modifier = Modifier.wrapContentSize(Alignment.Center),
                        text = it.toString(),
                        textAlign = TextAlign.Center,
                        fontSize = Dimens.defaultTextSize,
                        fontStyle = FontStyle.Italic
                    )
                    Spacer(modifier = Modifier.height(style.spacing))
                }

                body?.invoke()

                onOkay?.let {
                    Column {
                        PrimaryButton(
                            label = Strings.OK,
                            icon = Icons.Filled.Done,
                            onClick = { onOkay() })
                    } // Column
                }

                onCancel?.let {
                    Column {
                        SecondaryButton(
                            label = Strings.CANCEL,
                            icon = Icons.Filled.Cancel,
                            onClick = { onCancel.invoke() }
                        )
                    } // Column
                }

            } // Column
        } // Card
    } // Dialog
}