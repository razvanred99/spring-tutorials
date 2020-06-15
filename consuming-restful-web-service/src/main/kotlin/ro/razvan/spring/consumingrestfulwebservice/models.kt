package ro.razvan.spring.consumingrestfulwebservice

import com.fasterxml.jackson.annotation.JsonIgnoreProperties

@JsonIgnoreProperties(ignoreUnknown = true)
data class Quote(val type: String, val value: Value)

@JsonIgnoreProperties(ignoreUnknown = true)
data class Value(val id: Int, val quote: String)