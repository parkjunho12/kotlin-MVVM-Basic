package com.android.mvvmtest.viewmodel

import android.content.ContentValues
import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.android.mvvmtest.Model.DataModel
import com.android.mvvmtest.Model.response.ReqHeader
import com.android.mvvmtest.Model.response.RequestFormat
import com.android.mvvmtest.base.BaseViewModel
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import okhttp3.ResponseBody

class DetailViewModel (private val dataModel: DataModel): BaseViewModel(){

    private val _webSocketResponse = MutableLiveData<ResponseBody>()
    val webSocketResponse: LiveData<ResponseBody>
        get() = _webSocketResponse

    fun addDispos(reqHeader: ReqHeader, reqBody: RequestFormat?) {
        addtodisposable(dataModel.CallHttpRequest(reqHeader = reqHeader, reqBody = reqBody)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({
                it.run {
                    distributeSVC(response = this)
                }
            }, {
                Log.d(ContentValues.TAG, "response error, message : ${it.message}")
            }))
    }

    override fun distributeSVC(response: ResponseBody) {
        super.distributeSVC(response)
    }

}