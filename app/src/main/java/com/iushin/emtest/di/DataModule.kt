package com.iushin.emtest.di

import android.content.Context
import androidx.room.Room
import com.google.gson.Gson
import com.iushin.data.database.AppDatabase
import com.iushin.data.database.DatabaseMapper
import com.iushin.data.network.NetworkClient
import com.iushin.data.network.NetworkMapper
import com.iushin.data.network.RetrofitMockApi
import com.iushin.data.network.RetrofitNetworkClient
import org.koin.android.ext.koin.androidContext
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


val dataModule = module {

    single { androidContext().getSharedPreferences("chosen_prefrences", Context.MODE_PRIVATE) }

    single<RetrofitMockApi> {
        Retrofit.Builder()
            .baseUrl("https://drive.usercontent.google.com/u/0/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(RetrofitMockApi::class.java)
    }

    factory { Gson() }

    factory { NetworkMapper() }

    factory { DatabaseMapper(get()) }

    single<NetworkClient> {
        RetrofitNetworkClient(get())
    }

    single {
        Room.databaseBuilder(androidContext(), AppDatabase::class.java, "database.db")
            .fallbackToDestructiveMigration()
            .build()
    }
}