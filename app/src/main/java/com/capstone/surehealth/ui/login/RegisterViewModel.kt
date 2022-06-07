package com.capstone.surehealth.ui.login

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.capstone.surehealth.data.retrofit.ApiConfig
import com.capstone.surehealth.data.response.RegisterResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class RegisterViewModel: ViewModel() {

    val userRegister= MutableLiveData<RegisterResponse>()

    fun setRegister(username: String, email:String, password:String){
        val retro = ApiConfig.getApi()
        retro.postRegister(username, email, password).enqueue(object : Callback<RegisterResponse>{
            override fun onResponse(
                call: Call<RegisterResponse>,
                response: Response<RegisterResponse>
            ) {
                if (response.isSuccessful){
                    userRegister.postValue(response.body())
                    Log.e(TAG, "Success to connect Api to register")
                }
            }

            override fun onFailure(call: Call<RegisterResponse>, t: Throwable) {
                Log.e(TAG, "error ${t.message.toString()}")
                Log.e(TAG, "please, connect your internet")
            }

        })
    }

    fun getRegister(): LiveData<RegisterResponse> {
        return userRegister
    }

    companion object {
        const val TAG = "RegisterViewModel"
    }
}