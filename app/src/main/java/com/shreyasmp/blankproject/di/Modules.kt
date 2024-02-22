package com.shreyasmp.blankproject.di

import com.jakewharton.retrofit2.adapter.kotlin.coroutines.CoroutineCallAdapterFactory
import com.shreyasmp.blankproject.respository.InstrumentRepository
import com.shreyasmp.blankproject.respository.InstrumentRepositoryImpl
import com.shreyasmp.blankproject.service.Service
import com.shreyasmp.blankproject.viewmodel.InstrumentViewModel
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

val apiModule = module {
    fun provideInstrumentAPI(retrofit: Retrofit): Service {
        return retrofit.create(Service::class.java)
    }
    single { provideInstrumentAPI(get()) }
}

val networkModule = module {
    val SOURCE_URL = "https://gist.githubusercontent.com/"
    fun provideHttpLoggingInterceptor(): HttpLoggingInterceptor {
        return HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY)
    }

    fun provideOkHttpClient(
        httpLoggingInterceptor: HttpLoggingInterceptor,
    ): OkHttpClient {
        return OkHttpClient.Builder()
            .addInterceptor(httpLoggingInterceptor)
            .build()
    }

    fun provideRetrofit(okHttpClient: OkHttpClient): Retrofit {
        return Retrofit.Builder()
            .baseUrl(SOURCE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .addCallAdapterFactory(CoroutineCallAdapterFactory())
            .client(okHttpClient)
            .build()
    }

    single { provideHttpLoggingInterceptor() }
    single { provideOkHttpClient(get()) }
    single { provideRetrofit(get()) }
}

val repositoryModule = module {
    fun provideRepository(
        service: Service
    ): InstrumentRepository {
        return InstrumentRepositoryImpl(service)
    }
    single { provideRepository(get()) }
}

val viewModelModule = module {
    viewModel {
        InstrumentViewModel(repository = get())
    }
}


