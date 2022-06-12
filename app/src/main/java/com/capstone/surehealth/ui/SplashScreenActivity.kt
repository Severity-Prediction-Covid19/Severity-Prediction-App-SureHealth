package com.capstone.surehealth.ui

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import androidx.lifecycle.ViewModelProvider
import com.capstone.surehealth.R
import com.capstone.surehealth.data.ViewModelFactory
import com.capstone.surehealth.data.model.UserPreference
import com.capstone.surehealth.ui.login.LoginViewModel
import com.capstone.surehealth.ui.login.OnboardingActivity
import com.capstone.surehealth.ui.login.dataStore
import com.capstone.surehealth.ui.main.MainActivity
import com.capstone.surehealth.ui.result.ResultActivity

@SuppressLint("CustomSplashScreen")
class SplashScreenActivity : AppCompatActivity() {
    private val duration = 3000L
    private lateinit var loginViewModel: LoginViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash_screen)

        Handler(Looper.getMainLooper()).postDelayed({
            loginViewModel = ViewModelProvider(
                this,
                ViewModelFactory(UserPreference.getInstance(dataStore))
            )[LoginViewModel::class.java]

            loginViewModel.getToken().observe(this){
                if(it.id_user != ""){
                    finish()
                    val intent = Intent(this, MainActivity::class.java)
                    startActivity(intent)
                } else {
                    val intent = Intent(this, OnboardingActivity::class.java)
                    startActivity(intent)
                }
            }
            finish()
        }, duration)
    }
}