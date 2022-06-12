package com.capstone.surehealth.ui.history

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.capstone.surehealth.R
import com.capstone.surehealth.databinding.ActivityHistoryBinding
import com.capstone.surehealth.databinding.ActivityRegisterBinding
import com.capstone.surehealth.ui.login.LoginActivity
import com.capstone.surehealth.ui.main.MainActivity

class HistoryActivity : AppCompatActivity() {

    private lateinit var binding : ActivityHistoryBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityHistoryBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.ivback.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }

    }
}