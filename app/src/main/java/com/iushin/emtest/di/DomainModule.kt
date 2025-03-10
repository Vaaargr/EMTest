package com.iushin.emtest.di

import com.iushin.domain.api.ChosenFragmentInteractor
import com.iushin.domain.api.GetDateInteractor
import com.iushin.domain.api.SearchFragmentDatabaseInteractor
import com.iushin.domain.impl.ChosenFragmentInteractorImpl
import com.iushin.domain.impl.GetDateInteractorImpl
import com.iushin.domain.impl.SearchFragmentDatabaseInteractorImpl
import org.koin.dsl.module

val domainModule = module {

    single<GetDateInteractor> {
        GetDateInteractorImpl(get())
    }

    single<SearchFragmentDatabaseInteractor> {
        SearchFragmentDatabaseInteractorImpl(get())
    }

    single<ChosenFragmentInteractor> {
        ChosenFragmentInteractorImpl(get())
    }
}