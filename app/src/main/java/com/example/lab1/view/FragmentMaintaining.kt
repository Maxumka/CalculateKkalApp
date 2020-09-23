package com.example.lab1.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import com.example.lab1.R
import com.example.lab1.databinding.FragmentMaintainingBinding
import com.example.lab1.viewModel.FragmentMaintainingViewModel

class FragmentMaintaining : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val binding: FragmentMaintainingBinding = DataBindingUtil.inflate(inflater, R.layout.fragment_maintaining, container, false)
        binding.viewModel = FragmentMaintainingViewModel(activity!!.application)
        binding.lifecycleOwner = this
        return binding.root
    }
}