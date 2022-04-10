package cz.pilulka.aircraftmap.features.main

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.IconButton
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import com.google.accompanist.insets.ProvideWindowInsets
import com.google.accompanist.insets.imePadding
import com.google.accompanist.insets.navigationBarsWithImePadding
import com.google.accompanist.insets.statusBarsPadding
import cz.pilulka.aircraftmap.coroutines.collectAsStateValue
import cz.pilulka.aircraftmap.navigation.graph.ApplicationGraph
import cz.pilulka.aircraftmap.navigation.graph.LocalNavController
import cz.pilulka.aircraftmap.navigation.host.*
import cz.pilulka.compose.keyboard.keyboardAsState
import cz.pilulka.compose.resources.Colors
import cz.pilulka.compose.resources.Dimens
import cz.pilulka.compose.resources.Icons
import cz.pilulka.extension.empty

@Composable
fun MainHost(viewModel: MainViewModel) {

    val navController = LocalNavController.current

    var host by remember { mutableStateOf<Host?>(null) }

    navController.addOnDestinationChangedListener { _, destination, _ ->
        host = destination.label.toString().extractHost()
    }

    val onBackPressed = viewModel.onBackPressed.collectAsStateValue()

    LaunchedEffect(onBackPressed) {
        if (true == onBackPressed) {
            when (host?.backPressStrategy) {
                BackPressStrategy.POP_BACKSTACK -> navController.popBackStack()
                BackPressStrategy.EXIT_APPLICATION -> viewModel.onExitRequest()
                else -> Unit
            }
            viewModel.resetBackPress()
        }
    }

    val isKeyboardOpened = keyboardAsState().value.isOpened()

    var scaffoldModifier = Modifier.statusBarsPadding()
    if (!isKeyboardOpened) scaffoldModifier = scaffoldModifier.navigationBarsWithImePadding()

    ProvideWindowInsets {
        Scaffold(
            modifier = scaffoldModifier,
            topBar = {
                if (host.showTopAppBar())
                    TopAppBar(
                        title = {
                            Text(
                                modifier = Modifier.fillMaxWidth(),
                                text = host?.title ?: String.empty,
                                color = Colors.white,
                                textAlign = if (host.isSubHost()) TextAlign.Start else TextAlign.Center,
                                fontSize = Dimens.appBarTextSize
                            )
                        }, // Title
                        navigationIcon = if (host.isSubHost()) {
                            {
                                IconButton(onClick = { navController.navigateUp() }) {
                                    Icons.BackArrowIcon()
                                }
                            }
                        } else null, // NavigationIcon
                        backgroundColor = Colors.blue
                    )
            },
            content = {
                Column(
                    modifier = Modifier
                        .fillMaxSize()
                        .imePadding()
                ) {
                    ApplicationGraph()
                }
            },
        )
    }
}