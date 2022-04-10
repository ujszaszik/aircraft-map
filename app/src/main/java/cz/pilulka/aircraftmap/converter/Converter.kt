package cz.pilulka.aircraftmap.converter

interface Converter<From, To> {

    fun convert(originalValue: From): To
}