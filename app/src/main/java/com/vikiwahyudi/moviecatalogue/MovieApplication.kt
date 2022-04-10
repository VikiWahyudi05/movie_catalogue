package com.vikiwahyudi.moviecatalogue

import android.app.Application
import com.vikiwahyudi.core.di.databaseModule
import com.vikiwahyudi.core.di.networkModule
import com.vikiwahyudi.core.di.repositoryModule
import com.vikiwahyudi.moviecatalogue.di.useCaseModule
import com.vikiwahyudi.moviecatalogue.di.viewModelModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin
import org.koin.core.logger.Level

class MovieApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidLogger(Level.NONE)
            androidContext(this@MovieApplication)
            modules(
                listOf(
                    databaseModule,
                    networkModule,
                    repositoryModule,
                    useCaseModule,
                    viewModelModule
                )
            )
        }
    }
}