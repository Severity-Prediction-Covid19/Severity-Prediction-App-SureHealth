package com.capstone.surehealth.ui.quiz

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.capstone.surehealth.R
import com.capstone.surehealth.databinding.FragmentQuiz2Binding


class QuizFragment2 : Fragment() {

    private var _binding: FragmentQuiz2Binding? = null
    private val binding get() = _binding!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentQuiz2Binding.inflate(inflater, container, false)
        return binding.root
    }
}