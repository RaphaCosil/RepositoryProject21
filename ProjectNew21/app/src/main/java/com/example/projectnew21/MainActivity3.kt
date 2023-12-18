package com.example.projectnew21

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.projectnew21.databinding.ActivityMain2Binding
import com.example.projectnew21.databinding.ActivityMain3Binding
import com.example.projectnew21.databinding.ActivityMain4Binding
import com.example.projectnew21.databinding.ActivityMainBinding

class MainActivity3 : AppCompatActivity() {
    private lateinit var binding: ActivityMain3Binding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMain3Binding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}