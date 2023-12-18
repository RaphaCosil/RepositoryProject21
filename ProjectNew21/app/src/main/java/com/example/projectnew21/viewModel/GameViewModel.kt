package com.example.projectnew21.viewModel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.projectnew21.dataClasses.ApiCard
import com.example.projectnew21.dataClasses.ApiCardList
import com.example.projectnew21.dataClasses.ApiDeck
import com.example.projectnew21.useCases.DeckUseCase
import org.koin.core.component.getScopeId

class GameViewModel(private val deckUseCase: DeckUseCase): ViewModel() {
    var deckLiveData= MutableLiveData<ApiDeck>()
    var cardListLiveData= MutableLiveData<MutableList<ApiCard>>(ArrayList())
    var pontuacao = MutableLiveData<Int>(0)

    fun newDeck() {
        deckUseCase.newDeck { deckResponse->

            deckLiveData.value=deckResponse
        }
    }
    fun drawCard(){
        deckLiveData.value?.let {
            deckUseCase.drawCard(it){ apiCardList ->
                val teste = mutableListOf<ApiCard>(apiCardList.cards[0])
                cardListLiveData.value?.let {
                        it1 -> teste.addAll(it1)
                    cardListLiveData.value = teste
                }
                calcularPontos(apiCardList.cards[0])
            }

        }
    }

    fun calcularPontos(card: ApiCard){
        if (card.value.equals("2") || card.value.equals("3") || card.value.equals(
                "4"
            )
            || card.value.equals("5") || card.value.equals("6") || card.value.equals(
                "7"
            )
            || card.value.equals("8") || card.value.equals("9")
        ) {
            val parsedInt = card.value.toInt()
            pontuacao.value = pontuacao.value?.plus(parsedInt)
        } else if (card.value.uppercase().equals("A")) {
            pontuacao.value = pontuacao.value?.plus(1)
        } else {
            pontuacao.value = pontuacao.value?.plus(10)
        }
    }
}