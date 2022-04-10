import config.AppConfig
import config.libraryConfig

plugins {
    id("com.android.library")
    id("kotlin-parcelize")
    kotlin("android")
    kotlin("kapt")
}

android {

    libraryConfig(AppConfig.libraryConfig)

    kotlinOptions {
        jvmTarget = AppConfig.JVM_TARGET
    }
}