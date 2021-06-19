package com.silva021.banking

import android.app.Application
import com.silva021.extract.di.dataModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin
import org.koin.core.logger.Level

class BankingApp : Application() {
    override fun onCreate() {
        super.onCreate()


        startKoin {
//            printLogger(Level.INFO)
            androidContext(this@BankingApp)
            modules(listOf(dataModule))
        }
    }
}