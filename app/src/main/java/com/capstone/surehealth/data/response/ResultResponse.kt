package com.capstone.surehealth.data.response

import com.google.gson.annotations.SerializedName

data class ResultResponse(

    @field:SerializedName("success")
    val success: Boolean,

    @field:SerializedName("message")
    val message: String,

    @field:SerializedName("history")
    val history: History
)

data class History(

    @field:SerializedName("data")
    val data: HistoryData
)

data class HistoryData(

    @field:SerializedName("id_riwayat")
    val idRiwayat: String,

    @field:SerializedName("id_user")
    val idUser: String,

    @field:SerializedName("nama_diagnosis")
    val namaDiagnosis: String,

    @field:SerializedName("nama_obat")
    val namaObat: String,

    @field:SerializedName("keterangan")
    val keterangan: String,

    @field:SerializedName("date")
    val date: String
)
