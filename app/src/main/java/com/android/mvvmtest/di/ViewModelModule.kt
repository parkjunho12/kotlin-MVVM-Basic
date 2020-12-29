package com.android.mvvmtest.di

import com.android.mvvmtest.viewmodel.DetailViewModel
import com.android.mvvmtest.viewmodel.MainViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val viewModelModule = module {
    viewModel {
        MainViewModel(get ())
    }
    viewModel {
        DetailViewModel(get())
    }
}
