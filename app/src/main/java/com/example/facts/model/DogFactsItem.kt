package com.example.facts.model


import com.google.gson.annotations.SerializedName

data class DogFactsItem(
    @SerializedName("fact")
    val fact: String
)