package com.capstone.surehealth.ui.login

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.capstone.surehealth.R
import com.capstone.surehealth.databinding.ActivityRegisterBinding


class RegisterActivity : AppCompatActivity() {


    private lateinit var binding: ActivityRegisterBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityRegisterBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setupAction()


        }

    private fun setupAction() {
        binding.RegisButton.setOnClickListener {
            registerAction()
//            registerViewModel.getRegister().observe(this) {
//                if (it.error == true) {
//                    showLoading(false)
//                    Toast.makeText(
//                        this@RegisterActivity,
//                        getString(R.string.email_already),
//                        Toast.LENGTH_SHORT
//                    ).show()
//                } else {
//                    showLoading(false)
//                    Toast.makeText(this@RegisterActivity, getString(R.string.register_success), Toast.LENGTH_SHORT).show()
//                    val intent = Intent(this@RegisterActivity, LoginActivity::class.java)
//                    startActivity(intent)
//                }
//            }
        }
    }

    private fun registerAction() {
        val name = binding.nameedit.text.toString()
        val email = binding.emailedit.text.toString()
        val password = binding.passwordEdit.text.toString()
        val password2 = binding.passwordEdit2.text.toString()
        when {
            name.isEmpty() && email.isEmpty() && password.isEmpty() && password2.isEmpty() -> {
                binding.nameedit.error = getString(R.string.fill_name)
                binding.emailedit.error = getString(R.string.fill_email)
                binding.passwordEdit.error = getString(R.string.fill_password)
                binding.passwordEdit2.error = getString(R.string.fill_password)
            }
            name.isEmpty() -> {
                binding.nameedit.error = getString(R.string.fill_name)
            }
            email.isEmpty() -> {
                binding.emailedit.error = getString(R.string.fill_email)
            }
            password.isEmpty() -> {
                binding.passwordEdit.error = getString(R.string.fill_password)
            }
            password2.isEmpty() -> {
                binding.passwordEdit2.error = getString(R.string.fill_password)
            }
            password.length < 6 -> {
                binding.passwordEdit.error = getString(R.string.password_less)
            }
            password2.length < 6 -> {
                binding.passwordEdit2.error = getString(R.string.password_less)
            }
            password2 != password -> {
                binding.passwordEdit2.error = getString(R.string.same_password)
            }
            name.isEmpty() && password.isEmpty() -> {
                binding.nameedit.error = getString(R.string.fill_name)
                binding.passwordEdit.error = getString(R.string.fill_password)
            }
        }
    }
    }
