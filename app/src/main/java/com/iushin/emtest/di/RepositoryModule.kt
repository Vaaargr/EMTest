package com.iushin.emtest.di

import com.iushin.data.ChosenFragmentRepositoryImpl
import com.iushin.data.GetDateRepositoryImpl
import com.iushin.data.SearchFragmentDatabaseRepositoryImpl
import com.iushin.domain.api.ChosenFragmentRepository
import com.iushin.domain.api.GetDateRepository
import com.iushin.domain.api.SearchFragmentDatabaseRepository
import org.koin.dsl.module

val repositoryModule = module {

    single<GetDateRepository> {
        GetDateRepositoryImpl(get(), get())
    }

    single<SearchFragmentDatabaseRepository> {
        SearchFragmentDatabaseRepositoryImpl(get(), get(), get())
    }

    single<ChosenFragmentRepository> {
        ChosenFragmentRepositoryImpl(get(), get(), get())
    }
}