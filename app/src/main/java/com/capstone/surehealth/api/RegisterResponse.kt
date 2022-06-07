package com.capstone.surehealth.api

import com.google.gson.annotations.SerializedName

data class RegisterResponse(

	@field:SerializedName("data")
	val data: Data,

	@field:SerializedName("success")
	val success: Boolean,

	@field:SerializedName("message")
	val message: String
)

data class Data(

	@field:SerializedName("password")
	val password: String,

	@field:SerializedName("id_user")
	val idUser: String,

	@field:SerializedName("email")
	val email: String,

	@field:SerializedName("username")
	val username: String
)
