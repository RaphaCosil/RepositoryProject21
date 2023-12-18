package com.example.projectnew21

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.projectnew21.databinding.ActivityMain4Binding
import com.example.projectnew21.databinding.ActivityMain5Binding

class MainActivity4 : AppCompatActivity() {
    private lateinit var binding: ActivityMain4Binding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMain4Binding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}