package com.example.lab1.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import com.example.lab1.R
import com.example.lab1.databinding.FragmentGainingBinding
import com.example.lab1.viewModel.FragmentGainingViewModel

class FragmentGaining : Fragment() {
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val binding: FragmentGainingBinding = DataBindingUtil.inflate(inflater, R.layout.fragment_gaining, container, false)
        binding.viewModel = FragmentGainingViewModel(activity!!.application)
        binding.lifecycleOwner = this
        return binding.root
    }
}