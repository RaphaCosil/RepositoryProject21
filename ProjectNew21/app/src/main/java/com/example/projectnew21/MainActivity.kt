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
    var deck: ApiDeck? = null
    private val viewModel: MainViewModel by viewModel()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val lista = mutableListOf<Int>()
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        Log.d("###############", "hello")
        binding.btTeste.setOnClickListener {
            Tela2()
        }
    }
    private fun Tela2() {
        val tela2 = Intent(this, MainActivity2::class.java)
        startActivity(tela2)
    }
}
