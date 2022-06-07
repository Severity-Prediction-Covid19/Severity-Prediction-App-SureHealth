package com.capstone.surehealth.api

import com.google.gson.annotations.SerializedName

data class LoginResponse(

	@field:SerializedName("success")
	val success: Boolean,

	@field:SerializedName("userName")
	val userName: String,

	@field:SerializedName("message")
	val message: String,

	@field:SerializedName("userId")
	val userId: String
)
