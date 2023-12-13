package com.example.projectnew21

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.core.content.ContextCompat.startActivity
import com.example.projectnew21.dataClasses.ApiCard
import com.example.projectnew21.dataClasses.ApiDeck
import com.example.projectnew21.databinding.ActivityMain2Binding
import com.example.projectnew21.databinding.ActivityMainBinding
import com.example.projectnew21.repository.DeckCardRepositoryImpl
import com.example.projectnew21.viewModel.GameViewModel
import com.example.projectnew21.viewModel.MainViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import org.koin.androidx.viewmodel.ext.android.viewModel

class MainActivity2 : ComponentActivity() {
    private lateinit var binding: ActivityMain2Binding
    var deck: ApiDeck? = null
    private val viewModel: GameViewModel by viewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel.newDeck()
        val lista = mutableListOf<Int>()
        binding = ActivityMain2Binding.inflate(layoutInflater)
        setContentView(binding.root)

        Log.d("###############", "hello world")
        Log.d("###############", "Return DeckId1")
        viewModel.deckLiveData.observe(this) {

            Toast.makeText(baseContext, it.deckId, Toast.LENGTH_SHORT).show()

        }
        binding.btDraw.setOnClickListener {
            viewModel.drawCard()
        }

        viewModel.pontuacao.observe(this) {
            Toast.makeText(baseContext, it, Toast.LENGTH_SHORT).show()
        }


        }
    }


