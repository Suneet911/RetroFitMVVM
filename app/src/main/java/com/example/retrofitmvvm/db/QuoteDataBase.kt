package com.example.retrofitmvvm.db

import android.content.Context
import androidx.lifecycle.ViewModelProvider.NewInstanceFactory.Companion.instance
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.retrofitmvvm.models.Result

@Database(entities = [Result::class], version = 1)
abstract class QuoteDataBase : RoomDatabase() {

    abstract fun quotesDao(): QuoteDao

    companion object {
        @Volatile
        private var INSTANCE: QuoteDataBase? = null

        fun getDataBase(context: Context): QuoteDataBase {

            if (INSTANCE == null) {
                synchronized(this) {
                    INSTANCE =
                        Room.databaseBuilder(context, QuoteDataBase::class.java, "quoteDB").build()
                }

            }
            return INSTANCE!!
        }

    }

}