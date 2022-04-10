package cz.pilulka.compose.input

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.IconButton
import androidx.compose.material.TextField
import androidx.compose.material.TextFieldDefaults
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.focus.focusRequester
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.KeyboardType
import cz.pilulka.compose.keyboard.KeyboardStyle
import cz.pilulka.compose.resources.Colors
import cz.pilulka.compose.resources.Dimens
import cz.pilulka.compose.resources.Icons
import cz.pilulka.extension.empty

@Composable
fun SearchField(
    onSearchRequest: (String) -> Unit,
    onSearchCancelled: () -> Unit,
) {

    var searchText by remember { mutableStateOf(String.empty) }

    val focusManager = LocalFocusManager.current
    val focusRequester = remember { FocusRequester() }

    val keyboardStyle = KeyboardStyle(KeyboardType.Text)

    TextField(
        value = searchText,
        onValueChange = { value ->
            searchText = value
            onSearchRequest(searchText)
        },
        modifier = Modifier
            .fillMaxWidth()
            .focusRequester(focusRequester),
        textStyle = TextStyle(
            color = Colors.blue,
            fontSize = Dimens.highlightTextSize
        ),
        leadingIcon = { Icons.SearchViewLeadingIcon() },
        trailingIcon = {
            if (searchText.isNotEmpty()) {
                IconButton(
                    onClick = {
                        searchText = String.empty
                        onSearchRequest(searchText)
                        onSearchCancelled()
                        focusManager.clearFocus()
                    }
                ) { Icons.SearchViewCloseIcon() }
            }
        },
        keyboardOptions = keyboardStyle.keyboardOptions,
        keyboardActions = keyboardStyle.keyboardActions,
        singleLine = true,
        shape = RectangleShape,
        colors = TextFieldDefaults.textFieldColors(
            textColor = Colors.blue,
            cursorColor = Colors.blue,
            leadingIconColor = Colors.blue,
            trailingIconColor = Colors.steelGray,
            backgroundColor = Colors.white,
            focusedIndicatorColor = Color.Transparent,
            unfocusedIndicatorColor = Color.Transparent,
            disabledIndicatorColor = Color.Transparent
        )
    )
}