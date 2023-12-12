//package com.example.projectnew21
//
//import androidx.lifecycle.SavedStateHandle
//import androidx.lifecycle.ViewModel
//import androidx.lifecycle.ViewModelProvider
//import androidx.lifecycle.ViewModelProvider.AndroidViewModelFactory.Companion.APPLICATION_KEY
//import androidx.lifecycle.createSavedStateHandle
//import androidx.lifecycle.viewmodel.initializer
//import androidx.lifecycle.viewmodel.viewModelFactory
//
//class ViewModel {
//
//
//    class MyViewModel(
//        private val myRepository: MyRepository,
//        private val savedStateHandle: SavedStateHandle
//    ) : ViewModel() {
//        // ViewModel logic
//
//        // Define ViewModel factory in a companion object
//        companion object {
//            val Factory: ViewModelProvider.Factory = viewModelFactory {
//                initializer {
//                    val savedStateHandle = createSavedStateHandle()
//                    val myRepository = (this[APPLICATION_KEY] as MyApplication).myRepository
//                    MyViewModel(
//                        myRepository = myRepository,
//                        savedStateHandle = savedStateHandle
//                    )
//                }
//            }
//        }
//    }
//}