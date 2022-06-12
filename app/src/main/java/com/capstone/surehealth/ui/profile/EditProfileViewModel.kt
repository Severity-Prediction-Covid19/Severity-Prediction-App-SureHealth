package com.capstone.surehealth.ui.profile

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.capstone.surehealth.data.response.Data
import com.capstone.surehealth.data.retrofit.ApiConfig
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class EditProfileViewModel : ViewModel(){
    var data = MutableLiveData<Data>()

    fun setProfile(id: String) {
        ApiConfig.getApi()
            .getProfile(id)
            .enqueue(object: Callback<Data> {
                override fun onResponse(
                    call: Call<Data>,
                    response: Response<Data>
                ) {
                    if (response.isSuccessful) {
                        data.postValue(response.body())
                    }
                }

                override fun onFailure(call: Call<Data>, error: Throwable) {
                    Log.d("Failure", error.message.toString())
                }

            })
    }

    fun getProfile(): LiveData<Data> {
        return data
    }
}