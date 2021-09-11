package com.example.facts.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.facts.repository.FactsRepository

class MainViewModelFactory (private val repository: FactsRepository) : ViewModelProvider.Factory{
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return MainViewModels(repository) as T
    }
}