package com.capstone.surehealth.ui.login

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.capstone.surehealth.databinding.ActivityOnboardingBinding


class OnboardingActivity : AppCompatActivity() {

    private lateinit var binding: ActivityOnboardingBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityOnboardingBinding.inflate(layoutInflater)
        setContentView(binding.root)


    }

}