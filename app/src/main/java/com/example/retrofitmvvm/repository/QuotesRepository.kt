package com.example.retrofitmvvm.repository

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.retrofitmvvm.api.QuoteService
import com.example.retrofitmvvm.db.QuoteDataBase
import com.example.retrofitmvvm.models.QuoteList

class QuotesRepository (private val quotesService: QuoteService, private val quoteDataBase: QuoteDataBase){

    private val quotesLiveData = MutableLiveData<QuoteList>()

    val quotes: LiveData<QuoteList>
        get() = quotesLiveData

    suspend fun getQuotes(page : Int){
        val result =quotesService.getQuotes(page)
        if (result?.body() != null){
            quoteDataBase.quotesDao().addQuotes(result.body()!!.results)
            quotesLiveData.postValue(result.body())
        }
    }

}