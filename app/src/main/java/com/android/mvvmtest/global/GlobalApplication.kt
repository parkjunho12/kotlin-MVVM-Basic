package com.android.mvvmtest.global

import android.app.Application
import com.android.mvvmtest.di.dataModule
import com.android.mvvmtest.di.netWorkModule
import com.android.mvvmtest.di.viewModelModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidFileProperties
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin
import org.koin.core.logger.Level

class GlobalApplication : Application(){
    companion object {
        var sessionkey = ""
    }


    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidLogger(Level.ERROR)

            androidContext(this@GlobalApplication)
            androidFileProperties()
            modules(listOf(netWorkModule, dataModule, viewModelModule))

        }
    }
}