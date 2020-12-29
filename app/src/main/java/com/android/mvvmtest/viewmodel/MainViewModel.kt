package com.android.mvvmtest.viewmodel

import android.content.ContentValues.TAG
import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import antiscamCrypto.AntiscamCrypto
import com.android.mvvmtest.Model.DataModel
import com.android.mvvmtest.Model.response.*
import com.android.mvvmtest.base.BaseViewModel
import com.android.mvvmtest.global.GlobalApplication
import com.google.gson.Gson
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import okhttp3.ResponseBody
import org.json.JSONObject

class MainViewModel (private val dataModel: DataModel): BaseViewModel(){


    private val _webSocketResponse = MutableLiveData<ResponseBody>()
    val webSocketResponse: LiveData<ResponseBody>
        get() = _webSocketResponse


    fun initIntro() {
        val reqHeader = ReqHeader("SVC0000")
        val reqBody = ReqSVC0000("PartnerLicence")
        addDispos(reqHeader, reqBody)
    }

    fun requestSessionKey(encryptSessionKey: String) {
        val reqHeader = ReqHeader("SVC0001")
        val reqBody = ReqSVC0001(encryptSessionKey)
        addDispos(reqHeader, reqBody)
    }


    fun requestGongzi() {
        val reqHeader = ReqHeader("SVC1001")

        addDispos(reqHeader, null)
    }

    fun addDispos(reqHeader: ReqHeader, reqBody: RequestFormat?) {
        addtodisposable(dataModel.CallHttpRequest(reqHeader = reqHeader, reqBody = reqBody)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({
                it.run {
                    distributeSVC(response = this)
                }
            }, {
                Log.d(TAG, "response error, message : ${it.message}")
            }))
    }

    override fun distributeSVC(response: ResponseBody) {
        var jsonString = response.string()
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
            "SVC0000" ->{
                if ( rspHeader.ErrCode != 0){
                    if (rspHeader.ErrMsg != "") {
                        showSnackbar(rspHeader.ErrMsg)
                    }
                }else{
                    showSnackbar(rspHeader.ErrMsg)
                    var rspBody = Gson().fromJson(jsonObj!!.get("Body").toString(), RspSVC0000::class.java)
                    var publicKey = AntiscamCrypto.getPublicKey(rspBody.EncPublicKey)
                    var sessionKey = AntiscamCrypto.genSessionKey()
                    GlobalApplication.sessionkey = sessionKey
//                    requestSessionKey(AntiscamCrypto.encryptSessionKey(publicKey, sessionKey))
                    requestGongzi()
                }
            }
            "SVC0001" ->{
                if ( rspHeader.ErrCode != 0){
                    if (rspHeader.ErrMsg != "") {
                        showSnackbar(rspHeader.ErrMsg)
                    }
                }else{
                    showSnackbar(rspHeader.ErrMsg)
                    requestGongzi()
                }
            }
            "SVC1001" ->{
                if ( rspHeader.ErrCode != 0){
                    if (rspHeader.ErrMsg != "") {
                        showSnackbar(rspHeader.ErrMsg)
                        _webSocketResponse.postValue(response)
                    }
                }else{

                    _webSocketResponse.postValue(response)
                    showSnackbar(response.string())
                }
            }
            else -> {
                showSnackbar(rspHeader.ErrMsg)
            }
        }
    }


}