package com.android.mvvmtest.di

import com.android.mvvmtest.Model.DataModelImpl
import com.android.mvvmtest.Model.DataModel
import com.android.mvvmtest.Model.WebSocketMain
import com.android.mvvmtest.Model.service.SendService
import com.android.mvvmtest.viewmodel.MainViewModel
import okhttp3.OkHttpClient
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

val netWorkModule = module {

    single <SendService>{
        val okHttpClient = OkHttpClient.Builder()
            .readTimeout(60, TimeUnit.SECONDS)
            .connectTimeout(60, TimeUnit.SECONDS)
            .build()
        Retrofit.Builder()
            .baseUrl("https://svcapi.antiscam.co.kr:10031")
            .addConverterFactory(GsonConverterFactory.create())
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .client(okHttpClient)
            .build()
            .create(SendService::class.java)
    }
}

val webSocketModule = module {
    single {
        WebSocketMain()
    }
}

val dataModule = module {
        factory<DataModel>{
            DataModelImpl(get())
        }
}
