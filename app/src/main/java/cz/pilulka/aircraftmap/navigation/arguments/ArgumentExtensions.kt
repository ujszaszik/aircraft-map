package cz.pilulka.aircraftmap.navigation.arguments

import androidx.navigation.NavBackStackEntry
import com.squareup.moshi.Moshi

inline fun <reified T> NavBackStackEntry.retainParam(param: String): T? {
    return try {
        arguments?.getString(param)?.substring(param.length + 2)?.convertFromJson()
    } catch (thr: Throwable) {
        null
    }
}

inline fun <reified T> T?.toJson(): String {
    return Moshi.Builder().build().adapter(T::class.java).toJson(this)
}

inline fun <reified T> String.convertFromJson(): T? {
    return Moshi.Builder().build().adapter(T::class.java).fromJson(this)
}