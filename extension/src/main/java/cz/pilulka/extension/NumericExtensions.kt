package cz.pilulka.extension

fun Number?.formattedValue(postfix: Char): String {
    return this?.let {
        "$it$postfix"
    } ?: String.notAvailable
}

fun Number?.formattedValue(postfix: String): String {
    return this?.let {
        "$it $postfix"
    } ?: String.notAvailable
}