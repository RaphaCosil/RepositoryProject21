package com.example.projectnew21.viewModel

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.lifecycle.ViewModel
import com.example.projectnew21.dataClasses.ApiDeck
//import com.example.projectnew21.ui.theme.ProjectNew21Theme
import com.example.projectnew21.databinding.ActivityMain2Binding
import com.example.projectnew21.databinding.ActivityMainBinding
import com.example.projectnew21.repository.DeckCardRepository
import com.example.projectnew21.repository.DeckCardRepositoryImpl
import com.example.projectnew21.util.RetrofitClient
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

//class DeckViewModel (
//    private val repository: DeckCardRepository): ViewModel(){
//    var deck: ApiDeck?=null
//    fun newDeck(callback: (String) -> Unit) {
//        Log.d("###############", "NewDeck Inicio")
//        GlobalScope.launch{
//            DeckCardRepositoryImpl().novoBaralho()
//                .flowOn(Dispatchers.IO)
//                .catch {
//                    Log.d("###############", "Error creating deck")
//
//                    Toast.makeText(baseContext, it.message, Toast.LENGTH_SHORT).show()
//                }
//                .collect { apiDeck ->
//                    Log.d("###############", "Deck Created")
//                    Log.d("###############", apiDeck.deckId ?: "string null")
//                    withContext(Dispatchers.Main){
//                        callback(apiDeck.deckId)
//                        deck=apiDeck
//                        Toast.makeText(baseContext, apiDeck.deckId, Toast.LENGTH_SHORT).show()
//                    }
//                }
//
//        }
//        Log.d("###############", "NewDeck Fim")
//    }
//
//}