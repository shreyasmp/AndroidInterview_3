package com.shreyasmp.blankproject

import android.app.Application
import com.shreyasmp.blankproject.modules.apiModule
import com.shreyasmp.blankproject.modules.networkModule
import com.shreyasmp.blankproject.modules.repositoryModule
import com.shreyasmp.blankproject.modules.viewModelModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.GlobalContext.startKoin

class MainApplication : Application() {

    override fun onCreate() {
        super.onCreate()

        // Start Dependency Injection using koin
        startKoin {
            androidLogger()
            androidContext(this@MainApplication)
            modules(
                apiModule,
                networkModule,
                repositoryModule,
                viewModelModule
            )
        }
    }
}