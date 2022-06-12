package com.capstone.surehealth.ui.quiz

import android.content.SharedPreferences
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.CompoundButton
import com.capstone.surehealth.R
import com.capstone.surehealth.databinding.FragmentQuiz1Binding

class QuizFragment1 : Fragment() {

    private var _binding: FragmentQuiz1Binding? = null
    private val binding get() = _binding!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentQuiz1Binding.inflate(inflater, container, false)
        return binding.root
    }

}