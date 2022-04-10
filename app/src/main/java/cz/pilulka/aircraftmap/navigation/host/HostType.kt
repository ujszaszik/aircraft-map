package cz.pilulka.aircraftmap.navigation.host

enum class HostType {
    // Shows no App Bar
    DEFAULT,

    // Shows App Bar and Information Icon
    MAIN,

    // Shows App Bar with Search and List Icons
    SUB;

    val showAppBar: Boolean
        get() = this != DEFAULT

    val isSubType: Boolean
        get() = this == SUB

}