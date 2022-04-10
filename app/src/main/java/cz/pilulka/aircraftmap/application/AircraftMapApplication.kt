package cz.pilulka.aircraftmap.application

import com.jakewharton.threetenabp.AndroidThreeTen
import cz.pilulka.aircraftmap.BuildConfig
import cz.pilulka.network.NetworkUtil
import dagger.hilt.android.HiltAndroidApp
import timber.log.Timber
import javax.inject.Inject

@HiltAndroidApp
class AircraftMapApplication : android.app.Application() {

    @Inject
    lateinit var networkUtil: NetworkUtil

    override fun onCreate() {
        super.onCreate()
        if (BuildConfig.DEBUG) Timber.plant(Timber.DebugTree())
        AndroidThreeTen.init(this)
        networkUtil.registerNetworkCallback()
    }
}