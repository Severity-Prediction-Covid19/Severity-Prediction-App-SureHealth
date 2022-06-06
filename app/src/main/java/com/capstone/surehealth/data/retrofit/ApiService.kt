package com.capstone.surehealth.data.retrofit

import com.capstone.surehealth.data.response.LoginResponse
import com.capstone.surehealth.data.response.RegisterResponse
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.POST

interface ApiService {

    @FormUrlEncoded
    @POST("auth/api/v1/register")
    suspend fun postRegister(
        @Field("name") username: String,
        @Field("email") email: String,
        @Field("password") password: String
    ): RegisterResponse

    @FormUrlEncoded
    @POST("auth/api/v1/login")
    suspend fun postLogin(
        @Field("email") email: String,
        @Field("password") password: String
    ): LoginResponse
}