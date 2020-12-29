package com.android.mvvmtest.Model.response

import com.google.gson.annotations.SerializedName

data class ReqHeader(
        @SerializedName("CmdType") var CmdType: String,
        @SerializedName("OSType") var OSType: String = "AOS"
)

abstract class RequestFormat

data class ReqSVC0000(
        @SerializedName("PartnerLicence") var PartnerLicence: String
) :RequestFormat()

data class ReqSVC0001(
        @SerializedName("EncSessionKey") var EncSessionKey: String
) :RequestFormat()

data class ReqSVC1002(
        @SerializedName("PNumber") var PNumber: String,
        @SerializedName("Version") var Version: String,
        @SerializedName("ClientName") var ClientName: String
) :RequestFormat()

data class ReqSVC1003(
        @SerializedName("TeleType") var TeleType: String,
        @SerializedName("PNumber") var PNumber: String,
        @SerializedName("PushToken") var PushToken: String,
        @SerializedName("Model") var Model: String,
        @SerializedName("GUID") var memberGUID: String
) :RequestFormat()

data class ReqSVC1004(
        @SerializedName("TeleType") var TeleType: String,
        @SerializedName("PNumber") var PNumber: String,
        @SerializedName("AuthType") var AuthType: String,
        @SerializedName("AppHashCode") var AppHashCode: String
) :RequestFormat()

data class ReqSVCPNumber(
        @SerializedName("PNumber") var PNumber: String
) :RequestFormat()


data class ReqSVC1018(
        @SerializedName("PNumber") var PNumber: String,
        @SerializedName("RecvPNumber") var RecvPNumber: String
) :RequestFormat()

data class ReqSVC1019(
        @SerializedName("PNumber") var PNumber: String,
        @SerializedName("PushToken") var PushToken: String,
        @SerializedName("TransID") var TransID: String
) :RequestFormat()

data class ReqSVC1010(
        @SerializedName("SuspicionNumVersion") var SuspicionNumVersion: Int
) :RequestFormat()

data class ReqSVC1005(
        @SerializedName("PNumber") var PNumber: String,
        @SerializedName("TransactionID") var TransactionID: String,
        @SerializedName("CryptoNumber") var CryptoNumber: String,
        @SerializedName("PCode") var PCode: String,
        @SerializedName("PushToken") var PushToken: String,
        @SerializedName("Model") var Model: String,
        @SerializedName("GUID") var GUID: String
)

data class ReqSVC1006(
        @SerializedName("ReqPNumber") var ReqPNumber: String,
        @SerializedName("RspPNumber") var RspPNumber: String,
        @SerializedName("TransType") var TransType: Int,
        @SerializedName("ModifyType") var ModifyType: Int
) :RequestFormat()

data class ReqSVC1007(
        @SerializedName("TransID") var TransID: String,
        @SerializedName("Decision") var Decision: Int
) :RequestFormat()

data class ReqSVC1017(
        @SerializedName("TransID") var TransID: String
) :RequestFormat()

data class ReqSVC1008(
        @SerializedName("MsgType") var MsgType: Int,
        @SerializedName("PNumber") var PNumber: String
) :RequestFormat()

data class ReqSVC1014(
        @SerializedName("Terms1Argee") var Terms1Argee: Int,
        @SerializedName("Terms2Argee") var Terms2Argee: Int,
        @SerializedName("Terms3Argee") var Terms3Argee: Int,
        @SerializedName("Terms4Argee") var Terms4Argee: Int,
        @SerializedName("Terms5Argee") var Terms5Argee: Int,
        @SerializedName("Terms6Argee") var Terms6Argee: Int,

        @SerializedName("TeleType") var TeleType: String,
        @SerializedName("PCode") var PCode: String,
        @SerializedName("PNumber") var PNumber: String,
        @SerializedName("PushToken") var PushToken: String,
        @SerializedName("Model") var Model: String,
        @SerializedName("GUID") var GUID: String

) :RequestFormat()


data class ReqSVC1016(
        @SerializedName("CallTime") var CallTime: String,
        @SerializedName("RecvPNumber") var RecvPNumber: String,
        @SerializedName("DamageContents") var DamageContents: String,
        @SerializedName("OtherContents") var OtherContents: String
) :RequestFormat()

data class ReqSVC9001(
        @SerializedName("Telecom") var Telecom: String,
        @SerializedName("PNumber") var PNumber: String,
        @SerializedName("DeviceName") var DeviceName: String,
        @SerializedName("PackageList") var PackageList: String,
        @SerializedName("PkgInstallList") var PkgInstallList: String
) :RequestFormat()

data class ReqSVC1024(
        @SerializedName("PNumber") var PNumber: String,
        @SerializedName("CallPage") var CallPage: String
) :RequestFormat()



