package com.capstone.surehealth.ui.quiz

import android.app.FragmentTransaction
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.*
import com.capstone.surehealth.R
import com.capstone.surehealth.databinding.ActivityMainBinding
import com.capstone.surehealth.databinding.ActivityQuizBinding

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
        }

        binding.btnNext.btnLanjut.setOnClickListener {
            val nextFragment = QuizFragment2()
            supportFragmentManager.beginTransaction()
                .replace(R.id.fragmentContainer, nextFragment)
                .commit()
        }

    }

}