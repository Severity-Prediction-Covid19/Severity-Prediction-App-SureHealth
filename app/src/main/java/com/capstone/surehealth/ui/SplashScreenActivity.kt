package com.capstone.surehealth.ui

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import com.capstone.surehealth.R
import com.capstone.surehealth.ui.login.LoginActivity
import com.capstone.surehealth.ui.login.OnboardingActivity
import com.capstone.surehealth.ui.main.MainActivity
import com.capstone.surehealth.ui.result.ResultActivity

@SuppressLint("CustomSplashScreen")
class SplashScreenActivity : AppCompatActivity() {
    private val duration = 3000L

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash_screen)

        Handler(Looper.getMainLooper()).postDelayed({
            val intent = Intent(this, OnboardingActivity::class.java)
            startActivity(intent)
//            if (user.token == "") {
//                val intent = Intent(this, LoginActivity::class.java)
//                startActivity(intent)
//            } else {
//                val intent = Intent(this, MainActivity::class.java)
//                startActivity(intent)
//            }
            finish()
        }, duration)
    }
}