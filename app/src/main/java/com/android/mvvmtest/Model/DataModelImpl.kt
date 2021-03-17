package com.android.mvvmtest.Model

import antiscamCrypto.AntiscamCrypto
import com.android.mvvmtest.Model.response.ReqHeader
import com.android.mvvmtest.Model.service.SendService
import com.android.mvvmtest.global.GlobalApplication
import com.google.gson.Gson
import com.neovisionaries.ws.client.WebSocket
import com.neovisionaries.ws.client.WebSocketAdapter
import io.reactivex.Single
import okhttp3.ResponseBody
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject
import java.util.HashMap

class DataModelImpl(
    private val service: SendService
):DataModel {

    fun makeRequestDataPlain(header: ReqHeader, body: Any?) : String {
        val params = HashMap<String, Any>()
        params["Header"] = header
        if(body == null)
            params["Body"] = ""
        else
            params["Body"] = body

        var retData =  Gson().toJson(params)
//        if( GlobalApplication.sessionkey != ""){
//            retData = AntiscamCrypto.encryptData(GlobalApplication.sessionkey, retData)
//        }
        return retData
// return params
    }




    override fun CallHttpRequest(reqHeader: ReqHeader, reqBody: Any?): Single<ResponseBody> {
      return service.requestRestAPI(makeRequestDataPlain(reqHeader, reqBody))
    }
}