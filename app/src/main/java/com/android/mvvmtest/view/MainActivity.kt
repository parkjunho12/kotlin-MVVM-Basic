package com.android.mvvmtest.view

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import com.android.mvvmtest.Model.response.RspHeader
import com.android.mvvmtest.R
import com.android.mvvmtest.base.BaseActivity
import com.android.mvvmtest.databinding.ActivityMainBinding
import com.android.mvvmtest.viewmodel.MainViewModel
import com.google.gson.Gson
import org.json.JSONObject
import org.koin.androidx.viewmodel.ext.android.viewModel

class MainActivity : BaseActivity<ActivityMainBinding, MainViewModel>() {

    override val layoutResourceId: Int
        get() = R.layout.activity_main

    override val viewModel: MainViewModel by viewModel()

    override fun initStartView() {

    }

    override fun initDataBinding() {
        viewModel.webSocketResponse.observe(this, Observer {
            var jsonString = it.string()
            jsonString = jsonString.replace("\\", "").replace("\"{", "{")
            var jsonObj : JSONObject? = null
            try {
                jsonObj = JSONObject(jsonString)
            }catch (ex : java.lang.Exception)
            {
                jsonObj = null
            }
            var rspHeader = Gson().fromJson(jsonObj!!.get("Header").toString(), RspHeader::class.java)
            when(rspHeader.CmdType){
                "SVC1001" -> {
                    startActivity(Intent(this, DetailActivity::class.java))
                }
                else -> {

                }
            }

        })
    }

    override fun initAfterBinding() {
        viewModel.initIntro()
    }
}