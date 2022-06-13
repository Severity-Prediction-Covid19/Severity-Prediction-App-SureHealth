package com.capstone.surehealth.ui.quiz

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.fragment.app.*
import com.capstone.surehealth.R
import com.capstone.surehealth.databinding.ActivityQuizBinding
import com.capstone.surehealth.ui.result.ResultActivity

class QuizActivity : AppCompatActivity() {

    private lateinit var binding: ActivityQuizBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityQuizBinding.inflate(layoutInflater)
        setContentView(binding.root)

        if(savedInstanceState == null) {
            supportFragmentManager.commit {
                setReorderingAllowed(true)
                add<QuizFragment1>(R.id.fragmentContainer)
            }
        }

        binding.btnNext.btnKembali.setOnClickListener {
            val prevFragment = QuizFragment1()
            supportFragmentManager.beginTransaction()
                .replace(R.id.fragmentContainer, prevFragment)
                .commit()
            binding.btnNext.btnLanjut.visibility = View.VISIBLE
            binding.btnNext.btnHasil.visibility = View.GONE
            binding.btnNext.btnKembali.isEnabled = false
        }

        binding.btnNext.btnLanjut.setOnClickListener {
            val nextFragment = QuizFragment2()
            supportFragmentManager.beginTransaction()
                .replace(R.id.fragmentContainer, nextFragment)
                .commit()
            binding.btnNext.btnLanjut.visibility = View.GONE
            binding.btnNext.btnHasil.visibility = View.VISIBLE
            binding.btnNext.btnKembali.isEnabled = true
        }

        binding.btnNext.btnHasil.setOnClickListener {
            val intent = Intent(this, ResultActivity::class.java)
            startActivity(intent)
            finish()
        }

    }

}