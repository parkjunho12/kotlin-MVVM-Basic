package com.android.mvvmtest

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.android.mvvmtest.Model.DataModel
import com.android.mvvmtest.Model.DataModelImpl
import com.android.mvvmtest.Model.service.SendService
import com.android.mvvmtest.di.dataModule
import com.android.mvvmtest.di.netWorkModule
import com.android.mvvmtest.di.viewModelModule
import com.android.mvvmtest.viewmodel.MainViewModel
import io.reactivex.schedulers.Schedulers.single
import okhttp3.OkHttpClient
import org.junit.After
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.core.context.startKoin
import org.koin.core.context.stopKoin
import org.koin.core.logger.Level
import org.koin.dsl.module
import org.koin.test.KoinTest
import org.koin.test.KoinTestRule
import org.koin.test.inject
import org.koin.test.mock.MockProvider
import org.koin.test.mock.MockProviderRule
import org.mockito.Mockito
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

open class AbstractKoinTest: KoinTest {
    @get:Rule
    val rule = KoinTestRule.create {
        printLogger(Level.DEBUG)
        modules(netWorkModule, dataModule, viewModelModule)
    }

    @get:Rule
    val mockProvider = MockProviderRule.create { clazz ->
        Mockito.mock(clazz.java)
    }

    @get:Rule
    var instantExecutorRule = InstantTaskExecutorRule()
}