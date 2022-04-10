package cz.pilulka.network.mapper

import kotlin.reflect.KClass

annotation class DataMapper(val mapperClass: KClass<*>)

annotation class DataMappedFrom(val mapperClass: KClass<*>)