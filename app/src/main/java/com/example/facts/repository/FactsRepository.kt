package com.example.facts.repository

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.facts.api.FactService
import com.example.facts.model.DogFacts
import com.example.facts.model.DogFactsItem


class FactsRepository (private val factService: FactService){
    private val factsLiveData = MutableLiveData<DogFacts>()

    val facts : LiveData<DogFacts>
        get() = factsLiveData

    suspend fun getFacts(number : Int){
        val result = factService.getFacts(number)
        //val dogFactsItem = FactService.getFacts(number)
        if(result?.body() != null){
            factsLiveData.postValue(result.body())
        }
    }
}