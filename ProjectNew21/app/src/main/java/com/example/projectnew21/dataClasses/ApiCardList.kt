package com.example.projectnew21.dataClasses

import com.google.gson.annotations.SerializedName
import com.example.projectnew21.dataClasses.ApiCard

data class ApiCardList(
    @SerializedName("cards")
     val cards: List<ApiCard>,
    )

