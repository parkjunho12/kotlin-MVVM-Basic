package com.android.mvvmtest.Model


import com.android.mvvmtest.Model.response.ReqHeader
import io.reactivex.Single
import okhttp3.ResponseBody

interface DataModel {
    fun CallHttpRequest(reqHeader : ReqHeader, reqBody : Any?) : Single<ResponseBody>
}