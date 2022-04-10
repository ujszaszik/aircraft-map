package cz.pilulka.aircraftmap.converter

class VelocityConverter(private val originalUnit: VelocityUnit) : Converter<Double?, Double?> {

    override fun convert(originalValue: Double?): Double? {
        return originalValue?.let {
            it * originalUnit.conversionRate
        }
    }
}