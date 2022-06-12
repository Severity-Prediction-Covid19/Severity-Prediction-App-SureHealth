package com.capstone.surehealth.data.response

import com.google.gson.annotations.SerializedName

data class HistoryResponse(

    @field:SerializedName("success")
    val success: Boolean,

    @field:SerializedName("message")
    val message: String,

    @field:SerializedName("data")
    val data: GetHistory
)

data class GetHistory(

    @field:SerializedName("history")
    val history: HistoryData
)

data class DeleteHistoryResponse(

    @field:SerializedName("success")
    val success: Boolean,

    @field:SerializedName("message")
    val message: String
)
