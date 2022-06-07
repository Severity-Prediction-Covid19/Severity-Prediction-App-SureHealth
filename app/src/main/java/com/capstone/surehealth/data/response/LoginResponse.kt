package com.capstone.surehealth.data.response

data class LoginResponse(
    val success: String,
    val userId: String,
    val userName: String,
    val message: String
)
