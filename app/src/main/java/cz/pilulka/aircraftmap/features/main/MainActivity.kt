package cz.pilulka.aircraftmap.features.main

import android.os.Build
import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.app.AppCompatDelegate
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.LaunchedEffect
import androidx.core.view.WindowCompat
import androidx.navigation.compose.rememberNavController
import cz.pilulka.aircraftmap.coroutines.collectAsStateValue
import cz.pilulka.aircraftmap.features.main.util.KeyboardManager
import cz.pilulka.aircraftmap.features.main.util.LocalKeyboardManager
import cz.pilulka.aircraftmap.navigation.graph.LocalNavController
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private val viewModel: MainViewModel by viewModels()

    @RequiresApi(Build.VERSION_CODES.O)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)
        WindowCompat.setDecorFitsSystemWindows(window, false)

        setContent {
            val navController = rememberNavController()
            val keyboardManager = KeyboardManager(this)

            val exitRequest = viewModel.onExitRequest.collectAsStateValue()
            LaunchedEffect(exitRequest) {
                if (true == exitRequest) finishAffinity().run { viewModel.resetExitRequest() }
            }

            CompositionLocalProvider(
                LocalNavController provides navController,
                LocalKeyboardManager provides keyboardManager
            ) { MainHost(viewModel) }
        }
    }

    override fun onBackPressed() {
        viewModel.onBackPressed()
    }

}