package com.capstone.surehealth.data.retrofit


import com.capstone.surehealth.data.response.Data
import com.capstone.surehealth.data.response.LoginResponse
import com.capstone.surehealth.data.response.RegisterResponse
import retrofit2.Call
import retrofit2.http.*


interface ApiService {
    @FormUrlEncoded
    @POST("/auth/api/v1/login")
    fun postLogin(
        @Field("email") email: String,
        @Field("password") password : String
    ): Call<LoginResponse>

    @FormUrlEncoded
    @POST("/auth/api/v1/register")
    fun postRegister(
        @Field("username") username: String,
        @Field("email") email: String,
        @Field("password") password: String
    ): Call<RegisterResponse>

    @GET("/user/:id")
    fun getProfile(
        @Field("id_user") id_user: String
    ): Call<Data>

    @PUT("/user/update")
    fun updateProfile(
        @Field("id_user") id_user: String,
        @Field("username") username: String,
        @Field("email") email: String,
        @Field("password") password: String
    ): Call<Data>

    @DELETE("/user/delete")
    fun deleteProfile(
        @Field("id_user") id_user: String
    ): Call<Data>
}

