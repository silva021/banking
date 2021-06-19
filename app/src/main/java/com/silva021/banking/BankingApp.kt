package com.silva021.banking

import android.app.Application
import com.silva021.credit.di.creditModule
import com.silva021.extract.di.extractModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class BankingApp : Application() {
    override fun onCreate() {
        super.onCreate()


        startKoin {
//            printLogger(Level.INFO)
            androidContext(this@BankingApp)
            modules(listOf(extractModule, creditModule))
        }
    }
}