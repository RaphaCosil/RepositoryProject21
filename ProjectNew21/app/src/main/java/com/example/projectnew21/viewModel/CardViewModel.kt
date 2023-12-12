package com.example.projectnew21.viewModel

import android.util.Log
import android.widget.Toast
import androidx.lifecycle.ViewModel
import com.example.projectnew21.repository.DeckCardRepository
import com.example.projectnew21.repository.DeckCardRepositoryImpl
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
//
//class CardViewModel (
//    private val repository: DeckCardRepository): ViewModel(){
//    fun drawCard(deckId:String) {
//        GlobalScope.launch {
//            DeckCardRepositoryImpl().comprarCarta(deckId)
//                .catch {
//                    Log.d("###############", "Error in drawing the card")
//                    Toast.makeText(baseContext, it.message, Toast.LENGTH_SHORT).show()
//                }
//                .collect { apiCard ->
//                    Log.d("###############", "Card drawn")
//                    Log.d("###############", apiCard.cards[0].code ?: "string null")
//                    withContext(Dispatchers.Main) {
//                        Toast.makeText(baseContext, apiCard.cards[0].code, Toast.LENGTH_SHORT).show()
//                    }
//                }
//        }
//    }
//    }
//}