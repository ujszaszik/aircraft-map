package cz.pilulka.aircraftmap.data

import cz.pilulka.aircraftmap.R
import javax.inject.Inject

class CountryDataFileProcessor @Inject constructor(private val reader: RawFileReader) {

    companion object {
        private const val COUNTRY_DATA_ID = R.raw.country_bounds
        private const val FIELDS_COUNT = 5
    }

    fun getElements(): List<CountryData> {
        val countryDataList = mutableListOf<CountryData>()
        val fileContent = reader.getContent(COUNTRY_DATA_ID)
        val splitContent = fileContent.split(",")

        for (i in 0 until splitContent.size - 1 step FIELDS_COUNT) {
            countryDataList.add(
                CountryData(
                    name = splitContent[i].trim(),
                    minLongitude = getFormattedDouble(splitContent[i + 1]),
                    minLatitude = getFormattedDouble(splitContent[i + 2]),
                    maxLongitude = getFormattedDouble(splitContent[i + 3]),
                    maxLatitude = getFormattedDouble(splitContent[i + 4]),
                )
            )
        }

        return countryDataList
    }

    private fun getFormattedDouble(rawValue: String): Double {
        return rawValue.trim().toDouble()
    }
}