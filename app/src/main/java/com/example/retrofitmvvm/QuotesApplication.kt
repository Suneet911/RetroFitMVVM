package com.example.retrofitmvvm

import android.app.Application
import com.example.retrofitmvvm.api.QuoteService
import com.example.retrofitmvvm.api.RetrofitHelper
import com.example.retrofitmvvm.db.QuoteDataBase
import com.example.retrofitmvvm.repository.QuotesRepository

class QuotesApplication: Application() {

    lateinit var quotesRepository: QuotesRepository

    override fun onCreate() {
        super.onCreate()
        initialise()
    }

    private fun initialise(){
        val quoteService = RetrofitHelper.getInstance().create(QuoteService::class.java)
        val database= QuoteDataBase.getDataBase(applicationContext)

        quotesRepository = QuotesRepository(quoteService, database)
    }
}