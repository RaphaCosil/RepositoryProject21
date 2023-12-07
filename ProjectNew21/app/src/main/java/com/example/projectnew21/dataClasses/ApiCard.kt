package com.example.projectnew21.dataClasses
import com.google.gson.annotations.SerializedName

data class ApiCard(
    @SerializedName("code")
    val code: String="",
    @SerializedName("value")
    val value: String = "",
)
