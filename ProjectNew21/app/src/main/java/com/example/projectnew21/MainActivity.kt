package com.example.projectnew21

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.activity.ComponentActivity
import com.example.projectnew21.dataClasses.ApiDeck
import com.example.projectnew21.databinding.ActivityMainBinding
import com.example.projectnew21.viewModel.MainViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel

class MainActivity : ComponentActivity() {
    private lateinit var binding: ActivityMainBinding
    var deck: ApiDeck?=null
    private val viewModel:MainViewModel by viewModel()

//    fun newDeck(callback: (String) -> Unit) {
//        Log.d("###############", "NewDeck Inicio")
//        GlobalScope.launch{
//            DeckCardRepositoryImpl().novoBaralho()
//                .flowOn(Dispatchers.IO)
//                .catch {
//                    Log.d("###############", "Error creating deck")
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

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        Log.d("###############","hello")
        binding.btTeste.setOnClickListener{
            Tela2()
        }
        Log.d("###############", "hello world")
        Log.d("###############","Return DeckId1")
        viewModel.deckLiveData.observe(this){
            viewModel.drawCard()
            Toast.makeText(baseContext, it.deckId, Toast.LENGTH_SHORT).show()

        }

        viewModel.cardListLiveData.observe(this){
            Toast.makeText(baseContext, it.cards[0].code, Toast.LENGTH_SHORT).show()
        }
        viewModel.newDeck()



//        viewModel.newDeck{
//            Log.d("###############","NewDeck")
//            drawCard(it)
//            deck?.let{
//                drawCard(it.deckId)
//            }
//        }

    }

    private fun Tela2() {
        val tela2 = Intent(this,MainActivity2::class.java)
        startActivity(tela2)
    }
}