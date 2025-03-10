package com.iushin.emtest

import android.app.Application
import com.iushin.emtest.di.dataModule
import com.iushin.emtest.di.domainModule
import com.iushin.emtest.di.repositoryModule
import com.iushin.emtest.di.viewModelModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class App : Application() {
    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidContext(this@App)
            modules(dataModule, domainModule, repositoryModule, viewModelModule)
        }
    }
}