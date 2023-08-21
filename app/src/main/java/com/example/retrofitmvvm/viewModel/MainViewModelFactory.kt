package com.example.retrofitmvvm.viewModel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProvider.Factory
import com.example.retrofitmvvm.repository.QuotesRepository

class MainViewModelFactory(private val repository: QuotesRepository) : Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return MainViewModel(repository) as T
    }

}