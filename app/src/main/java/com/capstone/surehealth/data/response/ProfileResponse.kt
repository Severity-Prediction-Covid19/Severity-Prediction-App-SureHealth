package com.capstone.surehealth.data.response

import com.google.gson.annotations.SerializedName

data class GetProfile (

    @field:SerializedName("success")
    val success: Boolean,

    @field:SerializedName("message")
    val message: String,

    @field:SerializedName("userProfile")
    val userProfile: UserProfile
)

data class UserProfile(
    val data: Data
)

data class UpdateProfile(

    @field:SerializedName("success")
    val success: Boolean,

    @field:SerializedName("message")
    val message: String,

    @field:SerializedName("id_user")
    val idUser: String,

    @field:SerializedName("username")
    val username: String,

    @field:SerializedName("email")
    val email: String,

    @field:SerializedName("password")
    val password: String
)

data class DeleteProfile(
    @field:SerializedName("success")
    val success: Boolean,

    @field:SerializedName("message")
    val message: String
)