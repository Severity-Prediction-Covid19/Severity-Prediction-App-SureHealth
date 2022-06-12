package com.capstone.surehealth.ui.profile

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.capstone.surehealth.R
import com.capstone.surehealth.databinding.ActivityEditProfileBinding

class EditProfileActivity : AppCompatActivity() {
    private lateinit var binding: ActivityEditProfileBinding
    private lateinit var viewModel: EditProfileViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityEditProfileBinding.inflate(layoutInflater)
        setContentView(binding.root)

//        val id = intent.getStringExtra(EXTRA_ID)

//        viewModel.setProfile(id.toString())
//        viewModel.getProfile().observe(this) {
//            if(it != null) {
//                binding.apply {
//                    etNama.text = it.username
//                    etEmail.text = it.email
//                }
//            }
//        }

    }

    companion object {
        const val EXTRA_ID = "extra_id"
        const val EXTRA_USERNAME = "extra_username"
        const val EXTRA_EMAIL = "extra_email"
    }
}