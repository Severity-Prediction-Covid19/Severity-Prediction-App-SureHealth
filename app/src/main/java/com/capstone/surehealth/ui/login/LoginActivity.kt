package com.capstone.surehealth.ui.login

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.capstone.surehealth.R
import com.capstone.surehealth.databinding.ActivityLoginBinding

class LoginActivity : AppCompatActivity() {
    private lateinit var binding: ActivityLoginBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}