package com.example.projectnew21.dataClasses

import com.google.gson.annotations.SerializedName

data class ApiDeck(
        @SerializedName("deck_id")
        val deckId: String="",
        @SerializedName("remaining")
        val remaining: String = "",
)

