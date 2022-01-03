package com.leshchenko.movies

import android.app.Application
import com.leshchenko.movies.di.*
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.loadKoinModules
import org.koin.core.context.startKoin

class MoviesApp : Application() {

    override fun onCreate() {
        super.onCreate()
        initKoin()
    }

    private fun initKoin() = startKoin {
        androidLogger()
        androidContext(applicationContext)
        loadKoinModules(
            listOf(
                repositoryModule,
                apiModule,
                dataSourceModule,
                dbModule,
                retrofitModule,
            )
        )
    }
}