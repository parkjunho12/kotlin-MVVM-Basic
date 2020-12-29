package com.android.mvvmtest.Model.service


import io.reactivex.Single
import okhttp3.ResponseBody
import retrofit2.http.Body
import retrofit2.http.POST


interface SendService {
    @POST("/")
    fun requestRestAPI(@Body parameter: String): Single<ResponseBody>
}