package com.example.projectnew21

import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.projectnew21.dataClasses.ApiDeck
import com.example.projectnew21.repository.DeckCardRepositoryImpl
import com.example.projectnew21.ui.theme.ProjectNew21Theme
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class MainActivity : ComponentActivity() {
    var deck: ApiDeck?=null

    fun newDeck(callback: (String) -> Unit) {
        Log.d("###############", "NewDeck Inicio")
        GlobalScope.launch{
            DeckCardRepositoryImpl().novoBaralho()
                .flowOn(Dispatchers.IO)
                .catch {
                    Log.d("###############", "Error creating deck")
                    Toast.makeText(baseContext, it.message, Toast.LENGTH_SHORT).show()
                }
                .collect { apiDeck ->
                    Log.d("###############", "Deck Created")
                    Log.d("###############", apiDeck.deckId ?: "string null")
                    withContext(Dispatchers.Main){
                        callback(apiDeck.deckId)
                        deck=apiDeck
                        Toast.makeText(baseContext, apiDeck.deckId, Toast.LENGTH_SHORT).show()
                    }
                }

        }
        Log.d("###############", "NewDeck Fim")
    }
    fun drawCard(deckId:String) {
        GlobalScope.launch {
            DeckCardRepositoryImpl().comprarCarta(deckId)
                .catch {
                    Log.d("###############", "Error in drawing the card")
                    Toast.makeText(baseContext, it.message, Toast.LENGTH_SHORT).show()
                }
                .collect { apiCard ->
                    Log.d("###############", "Card drawn")
                    Log.d("###############", apiCard.cards[0].code ?: "string null")
                    withContext(Dispatchers.Main) {
                        Toast.makeText(baseContext, apiCard.cards[0].code, Toast.LENGTH_SHORT).show()
                    }
                }
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.d("###############", "hello world")
        Log.d("###############","Return DeckId1")
        newDeck{
            Log.d("###############","NewDeck")
            drawCard(it)
            deck?.let{
                drawCard(it.deckId)
            }
        }

    }


    @Composable
    fun Greeting(name: String, modifier: Modifier = Modifier) {
        Text(
            text = "Hello $name!",
            modifier = modifier
        )
    }

    @Preview(showBackground = true)
    @Composable
    fun GreetingPreview() {
        ProjectNew21Theme {
            Greeting("Android")
        }
    }
}