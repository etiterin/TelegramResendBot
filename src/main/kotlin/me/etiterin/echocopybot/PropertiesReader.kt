package me.etiterin.echocopybot

import java.util.*

private const val PROP_FILE_NAME = "apikey.properties"

class PropertiesReader(private val properties: Properties = Properties()) {

    init {
        val resourceStream = getResourceStream()
        resourceStream?.use {
            properties.load(resourceStream)
        }
    }

    fun getProperty(propertyName: String): String? = properties.getProperty(propertyName)

    private fun getResourceStream() = this::class.java.classLoader.getResourceAsStream(PROP_FILE_NAME)
}