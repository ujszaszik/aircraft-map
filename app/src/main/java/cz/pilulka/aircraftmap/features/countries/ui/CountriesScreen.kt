package cz.pilulka.aircraftmap.features.countries.ui

import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalFocusManager
import cz.pilulka.aircraftmap.features.countries.model.CountryModel
import cz.pilulka.aircraftmap.features.main.util.LocalKeyboardManager
import cz.pilulka.compose.input.SearchField
import cz.pilulka.compose.layout.TopCenterColumn
import cz.pilulka.compose.paging.PagingColumn

@Composable
fun CountriesScreen(
    countries: List<CountryModel>,
    onCountryClicked: (CountryModel) -> Unit,
    onCountrySearch: (String) -> Unit
) {

    val keyboardManager = LocalKeyboardManager.current

    val focusManager = LocalFocusManager.current

    TopCenterColumn {

        SearchField(
            onSearchRequest = { onCountrySearch(it) },
            onSearchCancelled = { keyboardManager.hide() })

        PagingColumn(
            items = countries,
            itemContent = { country, _ ->
                CountryItemScreen(
                    country = country,
                    onClick = {
                        onCountryClicked(country)
                        focusManager.clearFocus()
                    }
                )
            }
        )

    }
}