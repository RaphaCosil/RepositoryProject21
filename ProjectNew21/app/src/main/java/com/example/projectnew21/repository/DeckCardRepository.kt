package com.example.projectnew21.repository

import com.example.projectnew21.dataClasses.ApiCardList
import com.example.projectnew21.dataClasses.ApiDeck
import kotlinx.coroutines.flow.Flow
import retrofit2.http.Path

interface DeckCardRepository {
    suspend fun novoBaralho() : Flow<ApiDeck>
    suspend fun comprarCarta(@Path("deck_id") deckId:String) : Flow<ApiCardList>
    suspend fun embaralharCartas(@Path("deck_id") deckId:String) : Flow<Boolean>

}