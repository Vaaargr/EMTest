package com.iushin.emtest.di

import com.iushin.emtest.presentation.viewModels.ChosenViewModel
import com.iushin.emtest.presentation.viewModels.SearchViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val viewModelModule = module {
    viewModel { SearchViewModel(get(), get()) }

    viewModel { ChosenViewModel(get()) }
}