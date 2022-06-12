package com.capstone.surehealth.ui.login

import android.animation.AnimatorSet
import android.animation.ObjectAnimator
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.capstone.surehealth.R
import com.capstone.surehealth.databinding.ActivityRegisterBinding


class RegisterActivity : AppCompatActivity() {

    private lateinit var binding: ActivityRegisterBinding
    private lateinit var registerViewModel: RegisterViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityRegisterBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.tvintentLogin2.setOnClickListener {
            val intent = Intent(this@RegisterActivity, LoginActivity::class.java)
            startActivity(intent)
        }
        binding.ivBack.setOnClickListener {
            val intent = Intent(this@RegisterActivity, LoginActivity::class.java)
            startActivity(intent)
        }

        playAnimation()
        setupAction()
        setupViewModel()


    }

    private fun setupAction() {
        binding.RegisButton.setOnClickListener {
            registerAction()
            registerViewModel.getRegister().observe(this) {
                if (it.success == false) {
                    showLoading(false)
                    Toast.makeText(
                        this@RegisterActivity,
                        getString(R.string.email_already),
                        Toast.LENGTH_SHORT
                    ).show()
                } else {
                    showLoading(false)
                    Toast.makeText(
                        this@RegisterActivity,
                        getString(R.string.register_success),
                        Toast.LENGTH_SHORT
                    ).show()
                    val intent = Intent(this@RegisterActivity, LoginActivity::class.java)
                    startActivity(intent)
                }
            }
        }
    }


    private fun setupViewModel() {
        showLoading(false)
        registerViewModel = ViewModelProvider(
            this, ViewModelProvider.NewInstanceFactory()
        )[RegisterViewModel::class.java]
    }

    private fun registerAction() {
        val username = binding.nameedit.text.toString()
        val email = binding.emailedit.text.toString()
        val password = binding.passwordEdit.text.toString()
        val password2 = binding.passwordEdit2.text.toString()
        when {
            username.isEmpty() && email.isEmpty() && password.isEmpty() && password2.isEmpty() -> {
                binding.nameedit.error = getString(R.string.fill_name)
                binding.emailedit.error = getString(R.string.fill_email)
                binding.passwordEdit.error = getString(R.string.fill_password)
                binding.passwordEdit2.error = getString(R.string.fill_password)
            }
            username.isEmpty() -> {
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
            username.isEmpty() && password.isEmpty() -> {
                binding.nameedit.error = getString(R.string.fill_name)
                binding.passwordEdit.error = getString(R.string.fill_password)
            }
            else -> {
                showLoading(true)
                registerViewModel.setRegister(username, email, password)
            }
        }
    }
    private fun playAnimation(){
        val imageView = ObjectAnimator.ofFloat(binding.ivRegis, View.ALPHA, 1f).setDuration(3000)
        val textRegis = ObjectAnimator.ofFloat(binding.tvRegis, View.ALPHA, 1f).setDuration(3000)
        val textRegis2 = ObjectAnimator.ofFloat(binding.tvRegis2, View.ALPHA, 1f).setDuration(3000)
        val email = ObjectAnimator.ofFloat(binding.emailedit, View.ALPHA, 1f).setDuration(3000)
        val password = ObjectAnimator.ofFloat(binding.passwordEdit, View.ALPHA, 1f).setDuration(3000)
        val btnRegis = ObjectAnimator.ofFloat(binding.RegisButton, View.ALPHA, 1f).setDuration(3000)
        val intentRegis= ObjectAnimator.ofFloat(binding.tvintentLogin, View.ALPHA, 1f).setDuration(1000)
        val intentRegis2= ObjectAnimator.ofFloat(binding.tvintentLogin2, View.ALPHA, 1f).setDuration(1000)

        val title = AnimatorSet().apply {
            playTogether(imageView, textRegis, textRegis2)
        }

        val content = AnimatorSet().apply {
            playTogether(email, password, btnRegis)
        }

        ObjectAnimator.ofFloat(binding.ivRegis, View.TRANSLATION_Y, -30f, 30f).apply {
            duration = 4000
            repeatCount = ObjectAnimator.INFINITE
            repeatMode = ObjectAnimator.REVERSE
        }.start()

        AnimatorSet().apply {
            playSequentially(title, content, intentRegis,intentRegis2)
            start()
        }
  }


    private fun showLoading(state: Boolean){
        if(state){
            binding.progressBar.visibility = View.VISIBLE
        }else{
            binding.progressBar.visibility = View.GONE
        }
    }




}
