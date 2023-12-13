package com.example.projectnew21.viewModel

import android.content.Context
import android.util.Log
import android.widget.Toast
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.projectnew21.dataClasses.ApiCardList
import com.example.projectnew21.dataClasses.ApiDeck
import com.example.projectnew21.repository.DeckCardRepository
import com.example.projectnew21.repository.DeckCardRepositoryImpl
import com.example.projectnew21.useCases.DeckUseCase

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class MainViewModel (private val deckUseCase: DeckUseCase): ViewModel(){
    var deckLiveData= MutableLiveData<ApiDeck>()
    var cardListLiveData= MutableLiveData<ApiCardList>()

//    fun newDeck() {
//        deckUseCase.newDeck { deckResponse->
//
//            deckLiveData.value=deckResponse
//        }
//    }
//    fun drawCard(){
//        deckLiveData.value?.let {
//            deckUseCase.drawCard(it){ apiCardList ->
//
//                cardListLiveData.value=apiCardList
//        }
//
//        }
//
//    }

}