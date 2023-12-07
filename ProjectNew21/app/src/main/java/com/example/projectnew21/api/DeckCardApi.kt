package com.example.projectnew21.api

import com.example.projectnew21.dataClasses.ApiCardList
import com.example.projectnew21.dataClasses.ApiDeck
import retrofit2.http.GET
import retrofit2.http.Path
interface DeckCardApi {
    @GET(value = "/api/deck/new/shuffle/?deck_count=1")
    suspend fun novoBaralho() : ApiDeck
    @GET(value = "/api/deck/{deck_id}/draw/?count=1")
    suspend fun comprarCarta(@Path("deck_id") deckId:String) : ApiCardList

    //https://www.deckofcardsapi.com/api/deck/<<deck_id>>/shuffle/
    //Talvez tenha que usar esse link antes

    @GET(value = "/api/deck/{deck_id}/shuffle/?remaining=true")
    suspend fun embaralharCartas(@Path("deck_id") deckId:String) : Boolean

}
