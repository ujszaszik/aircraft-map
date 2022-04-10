package cz.pilulka.aircraftmap.features.main.splash

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.SharedFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SplashViewModel @Inject constructor() : ViewModel() {
    val _isSplashFinished = MutableSharedFlow<Boolean>()
    val isSplashFinished: SharedFlow<Boolean> = _isSplashFinished.asSharedFlow()

    init {
        makeSplashDelay()
    }

    private fun makeSplashDelay() {
        viewModelScope.launch {
            delay(SPLASH_DELAY)
            _isSplashFinished.emit(true)
        }
    }

    companion object {
        private const val SPLASH_DELAY = 1500L
    }
}