package com.android.mvvmtest.Model

import android.os.Handler
import android.util.Log
import android.widget.Toast
import com.google.gson.Gson
import com.neovisionaries.ws.client.*
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import java.lang.Exception
import java.util.*


class WebSocketMain : WebSocketAdapter() {


    lateinit var callback: CallBackResponse
    lateinit var ws: WebSocket

    fun enqueue(callback: CallBackResponse) {
        this.callback = callback
    }


    fun getWS(): WebSocket {
        try {
            if (!ws.isOpen) {
                connectServer()
            }
        } catch (ex: Exception) {
            connectServer()
        }
        return this.ws
    }



    fun connectServer() {
        this.ws = WebSocketFactory().createSocket("wss://dev-mcws.mfinder.co.kr:2030/app", 3000)
        this.ws.addListener(this)
        this.ws.connect()

    }

    override fun onTextMessage(websocket: WebSocket?, text: String?) {
        super.onTextMessage(websocket, text)
        Log.d("responseMsg", text.toString())
        callback.onResponse(text!!)
    }

    override fun onConnected(
        websocket: WebSocket?,
        headers: MutableMap<String, MutableList<String>>?
    ) {
        super.onConnected(websocket, headers)
        Log.i("network-log", "Connected")
    }

    fun sendData(cmdType: Int, reqBody: Any? = null, pNumber: String? = null) {
//        var sendData: String = makeSendData(getRequestHeader(cmdType), reqBody)
//        Log.i("sendData", "$cmdType:  $sendData")
//        rootScope.launch(Dispatchers.IO) {
//            try {
//                var ws = getWS()
//                ws.sendText(sendData)
//            } catch (e: Exception) {
//                e.printStackTrace()
//            }
//        }
    }



    override fun onDisconnected(
        websocket: WebSocket?,
        serverCloseFrame: WebSocketFrame?,
        clientCloseFrame: WebSocketFrame?,
        closedByServer: Boolean
    ) {


        super.onDisconnected(websocket, serverCloseFrame, clientCloseFrame, closedByServer)
    }

    override fun onError(websocket: WebSocket?, cause: WebSocketException?) {

        super.onError(websocket, cause)
    }

    override fun onConnectError(websocket: WebSocket?, exception: WebSocketException?) {

        Log.e("exceptionConnection", exception.toString())
        super.onConnectError(websocket, exception)
    }

    override fun onUnexpectedError(websocket: WebSocket?, cause: WebSocketException?) {

        super.onUnexpectedError(websocket, cause)
    }

    fun disconnectServer() {
        this.ws.disconnect()
        this.ws.sendClose()
    }
}