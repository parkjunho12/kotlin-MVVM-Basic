package com.android.mvvmtest.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import com.android.mvvmtest.R
import com.android.mvvmtest.base.BaseActivity
import com.android.mvvmtest.databinding.ActivityDetailBinding
import com.android.mvvmtest.databinding.ActivityMainBinding
import com.android.mvvmtest.viewmodel.DetailViewModel
import com.android.mvvmtest.viewmodel.MainViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel

class DetailActivity : BaseActivity<ActivityDetailBinding, DetailViewModel>()  {
    override val layoutResourceId: Int
        get() = R.layout.activity_detail

    override val viewModel: DetailViewModel by viewModel()

    override fun initStartView() {

    }

    override fun initDataBinding() {
        viewModel.webSocketResponse.observe(this, Observer {

        })
    }

    override fun initAfterBinding() {

    }
}