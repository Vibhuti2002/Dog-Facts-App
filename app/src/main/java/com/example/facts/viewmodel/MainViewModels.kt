package com.example.facts.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.facts.model.DogFacts
import com.example.facts.model.DogFactsItem
import com.example.facts.repository.FactsRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MainViewModels (private val repository: FactsRepository) : ViewModel() {
    init {
        viewModelScope.launch(Dispatchers.IO){
            repository.getFacts(25)
        }
    }
    val facts : LiveData<DogFacts>
        get() = repository.facts
}