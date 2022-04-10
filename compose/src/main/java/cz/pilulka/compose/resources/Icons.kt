package cz.pilulka.compose.resources

import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.Icon
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import cz.pilulka.extension.empty

object Icons {

    @Composable
    fun MapIcon() {
        Icon(
            Icons.Default.Map,
            contentDescription = String.empty,
            tint = Colors.white
        )
    }

    @Composable
    fun ListIcon() {
        Icon(
            Icons.Default.List,
            contentDescription = String.empty,
            tint = Colors.white
        )
    }

    @Composable
    fun BackArrowIcon() {
        Icon(
            Icons.Default.ArrowBack,
            contentDescription = String.empty,
            modifier = Modifier
                .padding(Dimens.paddingDefault)
                .size(Dimens.largerIconSize),
            tint = Colors.white
        )
    }

    @Composable
    fun SearchViewLeadingIcon() {
        Icon(
            Icons.Default.Search,
            contentDescription = String.empty,
            modifier = Modifier
                .padding(Dimens.paddingDefault)
                .size(Dimens.largerIconSize)
        )
    }

    @Composable
    fun SearchViewCloseIcon() {
        Icon(
            Icons.Default.Close,
            contentDescription = String.empty,
            modifier = Modifier
                .padding(Dimens.paddingDefault)
                .size(Dimens.largerIconSize)
        )
    }


}