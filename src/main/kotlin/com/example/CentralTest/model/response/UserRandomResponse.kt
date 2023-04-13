package com.example.CentralTest.model.response

import com.example.CentralTest.model.Info
import com.example.CentralTest.model.Results
import com.fasterxml.jackson.annotation.JsonIgnoreProperties

@JsonIgnoreProperties(ignoreUnknown = true)
data class UserRandomResponse (
    val results: List<Results>? = null,
    val info: Info? = null
)