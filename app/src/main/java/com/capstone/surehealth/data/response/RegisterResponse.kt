package com.capstone.surehealth.data.response

data class RegisterResponse (
    val success: Boolean,
    val message: String
)

data class RegisterData (
    val id_user: String,
    val username: String,
    val email: String,
    val password: String
)