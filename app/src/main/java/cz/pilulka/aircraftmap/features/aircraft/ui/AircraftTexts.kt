package cz.pilulka.aircraftmap.features.aircraft.ui

import cz.pilulka.extension.empty

object AircraftTexts {

    internal const val NO_DATA_AVAILABLE = "No data is available for this country"

    internal fun resultsHeader(countryName: String?): String {
        return "Results for: ${countryName ?: String.empty}"
    }

    internal fun refreshHeader(value: Long): String {
        return StringBuilder().apply {
            append("Refresh in ")
            append(value)
            append("sec")
            if (value > 1) append("s")
            append(".")
        }.toString()
    }
}