package com.example.projectnew21

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.core.content.ContextCompat.startActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.projectnew21.dataClasses.ApiCard
import com.example.projectnew21.dataClasses.ApiDeck
import com.example.projectnew21.dataClasses.RecyclerViewAdapter
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
    private var adapter: RecyclerViewAdapter?=null
    private val viewModel: GameViewModel by viewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel.newDeck()
        val lista = mutableListOf<Int>()
        binding = ActivityMain2Binding.inflate(layoutInflater)
        setContentView(binding.root)
        val recyclerView = binding.recyclerView

        val layoutManager = LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false)
        recyclerView.adapter = adapter

        Log.d("###############", "hello world")
        Log.d("###############", "Return DeckId1")
        viewModel.deckLiveData.observe(this) {

            Toast.makeText(baseContext, it.deckId, Toast.LENGTH_SHORT).show()

        }
        binding.btDraw.setOnClickListener {
                viewModel.drawCard()
        }

        viewModel.pontuacao.observe(this) {
            binding.txtPontuacao.text = "Total:"+ viewModel.pontuacao.value.toString()

            if(viewModel.pontuacao.value!! > 21){
                Tela3()
            }
            else if(viewModel.pontuacao.value!! == 21){
                Tela4()
            }
        }

        viewModel.cardListLiveData.observe(this){
            adapter = RecyclerViewAdapter(this, it)
            recyclerView.adapter = adapter
            recyclerView.layoutManager = layoutManager
        }


        }

    private fun Tela3() {
        val tela3 = Intent(this, MainActivity3::class.java)
        startActivity(tela3)
    }

    private fun Tela4() {
        val tela4 = Intent(this, MainActivity4::class.java)
        startActivity(tela4)
    }
    }


