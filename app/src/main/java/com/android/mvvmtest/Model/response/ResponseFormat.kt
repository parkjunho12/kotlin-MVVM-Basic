package com.android.mvvmtest.Model.response

import com.google.gson.annotations.SerializedName

data class RspHeader(
        @SerializedName("CmdType") var CmdType: String,
        @SerializedName("ErrCode") var ErrCode: Int,
        @SerializedName("ErrMsg") var ErrMsg:  String
)

data class RspSVC0000(
        @SerializedName("Data1") var EncPublicKey: String
)

data class RspSVC1001(
        @SerializedName("NoticeTitle") var NoticeTitle: String,
        @SerializedName("NoticeMsg")var NoticeMsg: String,
        @SerializedName("EventType")var EventType: Int
)

data class RspSVC1002(
        @SerializedName("URL") var URL: String,
        @SerializedName("Version")var Version: String
)

data class RspSVC1003(
        @SerializedName("GUID")var GUID: String
)

data class RspSVC1009(

        @SerializedName("msgs") var phisingMessageList: Array<RspSVC1009_Message>
)

data class RspSVC1009_Message(
        @SerializedName("keyword") var keyword : String,
        @SerializedName("descrition") var descrition: String,
        @SerializedName("level") var level : Int,
        @SerializedName("color") var color : String

)

data class RspSVC1010_Suspicion_Num(
        @SerializedName("SuspicionNumber")var SuspicionNumber: String,
        @SerializedName("UpdateType")var UpdateType: String
)

data class RspSVC1010_Designated_Num(
        @SerializedName("SenderPNumber")var SenderPNumber: String,
        @SerializedName("RecverPNumber")var RecverPNumber: String,
        @SerializedName("RecvStatus")var RecvStatus: Int,
        @SerializedName("TransID")var TransID: String,
        @SerializedName("TransType")var TransType: Int,
        @SerializedName("RespPNumber")var RespPNumber: String
)

data class RspSVC1010_Bankingapp(
        @SerializedName("AppName")var AppName: String,
        @SerializedName("PackageName")var PackageName: String
        )

data class RspSVC1010_WebViewList(
        @SerializedName("WebView1") var WebView1: String,
        @SerializedName("WebView2") var WebView2: String,
        @SerializedName("WebView3") var WebView3: String,
        @SerializedName("WebView4") var WebView4: String,
        @SerializedName("WebView5") var WebView5: String,
        @SerializedName("WebView6") var WebView6: String
)

data class RspSVC1010_ScamAppList(
        @SerializedName("AppName") var AppName: String,
        @SerializedName("PackageName") var PackageName: String,
        @SerializedName("UsePort") var UsePort: Int,
        @SerializedName("AppType") var AppType: Int

)



data class RspSVC1010(
        @SerializedName("Suspicion_Num_List")var Suspicion_Num_List: Array<RspSVC1010_Suspicion_Num>,
        @SerializedName("Designated_Num_List")var Designated_Num_List: Array<RspSVC1010_Designated_Num>,
        @SerializedName("BankingApp_List")var BankingApp_List: Array<RspSVC1010_Bankingapp>,
        @SerializedName("WebViewList")var WebViewList: RspSVC1010_WebViewList,
        @SerializedName("ScamApp_List")var ScamApp_List: Array<RspSVC1010_ScamAppList>
)

data class RspSVC1012(
        @SerializedName("Title") var Title: String,
        @SerializedName("ContentsGenre") var ContentsGenre: Int,
        @SerializedName("Url") var Url: String,
        @SerializedName("RegDT") var RegDT: String
)

data class RspSVC1013(
        @SerializedName("Title") var Title: String,
        @SerializedName("IconText") var IconText: String,
        @SerializedName("Url") var Url: String,
        @SerializedName("RegDT") var RegDT: String
)

data class RspSVC1015(
        @SerializedName("Designated_Num_List") var Designated_Num_List: Array<RspSVC1010_Designated_Num>
)

data class RspSVC1004(
        @SerializedName("TimeOut")var TimeOut: Int,
        @SerializedName("TransactionID")var TransactionID: String
)

data class RspSVC1005(
        @SerializedName("FreeUserQualify")var FreeUserQualify: Int,
        @SerializedName("GUID")var memberGUID: String

)

data class RspSVC1014(
        @SerializedName("GUID")var memberGUID: String

)


data class RspSVC1018(
        @SerializedName("PName")var Name: String
)
