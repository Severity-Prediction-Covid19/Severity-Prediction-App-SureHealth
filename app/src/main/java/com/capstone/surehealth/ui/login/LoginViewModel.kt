package com.capstone.surehealth.ui.login

import android.util.Log
import androidx.lifecycle.*
import com.capstone.surehealth.data.Event
import com.capstone.surehealth.data.model.User
import com.capstone.surehealth.data.model.UserPreference
import com.capstone.surehealth.data.response.LoginResponse
import com.capstone.surehealth.data.retrofit.ApiConfig
import kotlinx.coroutines.launch
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class LoginViewModel(private val pref: UserPreference) : ViewModel() {

    val userLogin = MutableLiveData<LoginResponse>()

    private val _isLoading = MutableLiveData<Boolean>()
    val isLoading: LiveData<Boolean> = _isLoading

    private val _snackBarText = MutableLiveData<Event<String>>()
    val snackBarText: LiveData<Event<String>> = _snackBarText

    fun setLogin(email: String, password: String) {
        _isLoading.value = true
        val login = ApiConfig.getApi()
        login.postLogin(email, password).enqueue(object : Callback<LoginResponse> {
            override fun onResponse(call: Call<LoginResponse>, response: Response<LoginResponse>) {
                _isLoading.value = false
                if (response.isSuccessful) {
                    val responseBody = response.body()
                    if (responseBody != null && responseBody.success != false) {
                        userLogin.postValue(response.body())
                        _snackBarText.value = Event("Login Berhasil")
                        Log.e(TAG, "Connection success data is valid")
                    }
                    else {
                        Log.e(TAG, response.message())
                    }
                }
                else {
                    _snackBarText.value = Event("Maaf Email atau Password anda salah")
                    Log.e(TAG, response.body()?.message.toString())
                }
            }

            override fun onFailure(call: Call<LoginResponse>, t: Throwable) {
                _isLoading.value = false
                _snackBarText.value = Event("Maaf silahkan cek koneksi internet anda")
                Log.e(TAG, "error in failure ${t.message.toString()}")
            }

        })
    }

    fun getLogin(): LiveData<LoginResponse> {
        return userLogin
    }

    fun saveToken(user: User) {
        viewModelScope.launch {
            pref.saveidToken(user)
        }
    }

    fun getToken() : LiveData<User>{
        return pref.idtoken.asLiveData()
    }


    companion object {
        private const val TAG = "LoginViewModel"
    }

}
