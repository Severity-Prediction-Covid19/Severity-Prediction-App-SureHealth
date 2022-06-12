package com.capstone.surehealth.ui.login

import android.animation.AnimatorSet
import android.animation.ObjectAnimator
import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.preferencesDataStore
import androidx.lifecycle.ViewModelProvider
import com.capstone.surehealth.R
import com.capstone.surehealth.data.ViewModelFactory
import com.capstone.surehealth.data.model.User
import com.capstone.surehealth.data.model.UserPreference
import com.capstone.surehealth.databinding.ActivityLoginBinding

import com.capstone.surehealth.ui.main.MainActivity
import com.google.android.material.snackbar.Snackbar


val Context.dataStore: DataStore<Preferences> by preferencesDataStore(name = "settings")

class LoginActivity : AppCompatActivity() {
    private lateinit var binding: ActivityLoginBinding
    private lateinit var loginViewModel: LoginViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        showLoading(false)


        setupViewModel()
        setupAction()
        playAnimation()

        binding.tvRegister.setOnClickListener {
            val intent = Intent(this@LoginActivity, RegisterActivity::class.java)
            startActivity(intent)
        }
        binding.ivBack2.setOnClickListener {
            val intent = Intent(this@LoginActivity, OnboardingActivity::class.java)
            startActivity(intent)
        }
    }

    private fun setupViewModel() {
        loginViewModel = ViewModelProvider(
            this,
            ViewModelFactory(UserPreference.getInstance(dataStore))
        )[LoginViewModel::class.java]

        loginViewModel.getToken().observe(this){
            if(it.id_user != ""){
                finish()
                val intent = Intent(this@LoginActivity, MainActivity::class.java)
                startActivity(intent)
            }
        }

    }

    private fun setupAction() {
        binding.loginButton.setOnClickListener {
            login()
        }


        loginViewModel.isLoading.observe(this) {
            showLoading(false)
        }

        loginViewModel.snackBarText.observe(this) {
            it.getContentIfNotHandled()?.let { snackBarText ->
                Snackbar.make(
                    window.decorView.rootView,
                    snackBarText,
                    Snackbar.LENGTH_SHORT
                ).show()
            }
        }

        loginViewModel.getLogin().observe(this) {
            if (it.success == true && it != null) {
                loginViewModel.saveToken(
                    User(
                        id_user = it.userId,
                        state = true,

                    )
                )

                val intent = Intent(this@LoginActivity, MainActivity::class.java)
                intent.flags = Intent.FLAG_ACTIVITY_CLEAR_TASK or Intent.FLAG_ACTIVITY_NEW_TASK
                startActivity(intent)
                finish()
            }
            else {
                Toast.makeText(this@LoginActivity, getString(R.string.not_register), Toast.LENGTH_SHORT).show()
            }
        }
    }

    private fun login() {
        val email = binding.emailedit.text.toString()
        val password = binding.passwordEdit.text.toString()
        when {
            email.isEmpty() && password.isEmpty() -> {
                binding.emailedit.error = getString(R.string.fill_email)
                binding.passwordEdit.error = getString(R.string.fill_password)
            }
            else -> {
                loginViewModel.setLogin(email, password)
            }
        }
    }

    private fun playAnimation(){
        val imageView = ObjectAnimator.ofFloat(binding.ivLogin, View.ALPHA, 1f).setDuration(1000)
        val textLogin = ObjectAnimator.ofFloat(binding.tvLogin, View.ALPHA, 1f).setDuration(1000)
        val textLogin2 = ObjectAnimator.ofFloat(binding.tvLogin2, View.ALPHA, 1f).setDuration(1000)
        val email = ObjectAnimator.ofFloat(binding.emailedit, View.ALPHA, 1f).setDuration(1000)
        val password = ObjectAnimator.ofFloat(binding.passwordEdit, View.ALPHA, 1f).setDuration(1000)
        val btnLogin = ObjectAnimator.ofFloat(binding.loginButton, View.ALPHA, 1f).setDuration(1000)
        val textregis= ObjectAnimator.ofFloat(binding.tvRegister, View.ALPHA, 1f).setDuration(1000)
        val textregis2= ObjectAnimator.ofFloat(binding.tvRegister2, View.ALPHA, 1f).setDuration(500)

        val title = AnimatorSet().apply {
            playTogether(imageView, textLogin, textLogin2)
        }

        val content = AnimatorSet().apply {
            playTogether(email, password, btnLogin)
        }

        ObjectAnimator.ofFloat(binding.ivLogin, View.TRANSLATION_Y, -30f, 30f).apply {
            duration = 6000
            repeatCount = ObjectAnimator.INFINITE
            repeatMode = ObjectAnimator.REVERSE
        }.start()

        AnimatorSet().apply {
            playSequentially(title, content, textregis,textregis2)
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