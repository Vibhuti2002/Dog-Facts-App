package com.example.facts

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.TextView
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import com.example.facts.api.FactService
import com.example.facts.api.RetrofitHelper
import com.example.facts.model.DogFacts
import com.example.facts.repository.FactsRepository
import com.example.facts.viewmodel.MainViewModels
import com.example.facts.viewmodel.MainViewModelFactory
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity()  {
    private val printText : TextView
        get()= findViewById(R.id.facts)
    private val nextBtn : TextView
        get()= findViewById(R.id.nextbtn)
    private val previousBtn : TextView
        get()= findViewById(R.id.prevbtn)

    private var index =0;

    lateinit var mainViewModel : MainViewModels

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setFact(index)
    }
    fun setFact(index:Int){
        val quoteService = RetrofitHelper.getInstance().create(FactService::class.java)
        val repository = FactsRepository(quoteService)
        mainViewModel = ViewModelProvider(this,MainViewModelFactory(repository)).get(MainViewModels::class.java)
        mainViewModel.facts.observe(this, Observer{
            printText.text = it[index].fact.toString()
        })
    }
    fun nextFact(view : View){
        ++index
        setFact(index)
    }
    fun prevFact(view : View){
        --index
        setFact(index)
    }

}