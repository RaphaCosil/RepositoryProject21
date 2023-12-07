package com.example.projectnew21.repository

import com.example.projectnew21.dataClasses.ApiCardList
import com.example.projectnew21.dataClasses.ApiDeck
import com.example.projectnew21.api.DeckCardApi
import com.example.projectnew21.util.RetrofitClient
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class DeckCardRepositoryImpl: DeckCardRepository {
    override suspend fun novoBaralho(): Flow<ApiDeck> = flow {
        val retrofitClient = RetrofitClient.getRetrofitInstance("https://www.deckofcardsapi.com")
            val api = retrofitClient.create(DeckCardApi::class.java)
            val resposta = api.novoBaralho()
        emit(resposta)

        }

    override suspend fun comprarCarta(deckId: String): Flow<ApiCardList> = flow {
        val retrofitClient = RetrofitClient.getRetrofitInstance("https://www.deckofcardsapi.com")
        val api = retrofitClient.create(DeckCardApi::class.java)
        val resposta = api.comprarCarta(deckId)
        emit(resposta)
    }

    override suspend fun embaralharCartas(deckId: String): Flow<Boolean> = flow{
        val retrofitClient = RetrofitClient.getRetrofitInstance("https://www.deckofcardsapi.com")
        val api = retrofitClient.create(DeckCardApi::class.java)
        val resposta = api.embaralharCartas("deckId")
        emit(resposta)
    }


    }

