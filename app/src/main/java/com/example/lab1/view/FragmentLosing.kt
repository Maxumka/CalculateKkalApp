package com.example.lab1.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import com.example.lab1.R
import com.example.lab1.databinding.FragmentLosingBinding
import com.example.lab1.viewModel.FragmentLosingViewModel

class FragmentLosing : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val binding: FragmentLosingBinding = DataBindingUtil.inflate(inflater, R.layout.fragment_losing, container, false)
        binding.viewModel = FragmentLosingViewModel(activity!!.application)
        binding.lifecycleOwner = this
        return binding.root
    }
}