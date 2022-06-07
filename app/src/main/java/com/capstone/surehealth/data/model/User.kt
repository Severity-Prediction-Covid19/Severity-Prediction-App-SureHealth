package com.capstone.surehealth.data.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class User (
    var id_user: String? = ""
) : Parcelable