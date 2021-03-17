package com.android.mvvmtest.base

import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.ViewModel
import com.android.mvvmtest.Model.response.RspHeader
import com.android.mvvmtest.util.ToastMessage
import com.google.gson.Gson
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable
import okhttp3.ResponseBody
import org.json.JSONObject

open class BaseViewModel : ViewModel() {
    private val disposables: CompositeDisposable = CompositeDisposable()

    private val toastMessage = ToastMessage()
    fun addtodisposable(disposable: Disposable) {
        disposables.add(disposable)
    }

    override fun onCleared() {
        disposables.clear()
        super.onCleared()
    }


    fun showSnackbar(str:String){
        toastMessage.value = str
    }

    fun observeSnackbarMessage(lifeCycleOwner: LifecycleOwner, ob:(String) -> Unit){
        toastMessage.observe(lifeCycleOwner, ob)
    }





    open fun distributeSVC(response: ResponseBody) {
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
        if (rspHeader.ErrCode == 999999||rspHeader.ErrCode == 999998||rspHeader.ErrCode == 900004) { // 세션시간 만료
            showSnackbar(rspHeader.ErrMsg)
            return
        }
        when(rspHeader.CmdType){

            else -> {
                showSnackbar(rspHeader.ErrMsg)
            }
        }
    }


}