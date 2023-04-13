package com.example.CentralTest.model

data class Location (
    val street: Street? = null,
    val number: Int? = null,
    val city: String? = null,
    val state: String? = null,
    val country: String? = null,
    val postcode: String? = null,
    val coordinates: Coordinate? = null,
    val timezone: Timezone? = null
)