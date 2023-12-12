package com.example.projectnew21.useCases

import android.content.Context
import android.util.Log
import android.widget.Toast
import com.example.projectnew21.dataClasses.ApiCardList
import com.example.projectnew21.dataClasses.ApiDeck
import com.example.projectnew21.repository.DeckCardRepository
import com.example.projectnew21.repository.DeckCardRepositoryImpl
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class DeckUseCase(
    private val repository: DeckCardRepository
    ){
        fun newDeck(callback: (ApiDeck) -> Unit) {
            Log.d("###############", "NewDeck Inicio")
            GlobalScope.launch{
                DeckCardRepositoryImpl().novoBaralho()
                    .flowOn(Dispatchers.IO)
                    .catch {
                        Log.d("###############", "Error creating deck")
                        //Toast.makeText(baseContext, it.message, Toast.LENGTH_SHORT).show()
                    }
                    .collect { apiDeck ->
                        Log.d("###############", "Deck Created")
                        Log.d("###############", apiDeck.deckId ?: "string null")
                        withContext(Dispatchers.Main){
                            callback(apiDeck)
                            //Toast.makeText(baseContext, apiDeck.deckId, Toast.LENGTH_SHORT).show()
                        }
                    }

            }
            Log.d("###############", "NewDeck Fim")
        }
    fun drawCard(deck: ApiDeck, callback: (ApiCardList) -> Unit){

        GlobalScope.launch {
            DeckCardRepositoryImpl().comprarCarta(deck.deckId)
                .catch {
                    Log.d("###############", "Error in drawing the card")
                    //Toast.makeText(baseContext, it.message, Toast.LENGTH_SHORT).show()
                }
                .collect { apiCard ->
                    Log.d("###############", "Card drawn")
                    Log.d("###############", apiCard.cards[0].code ?: "string null")
                    withContext(Dispatchers.Main) {
                        callback(apiCard)
                        //Toast.makeText(baseContext, apiCard.cards[0].code, Toast.LENGTH_SHORT).show()
                    }
                }
        }

    }
}