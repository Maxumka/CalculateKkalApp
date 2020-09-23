package com.example.lab1.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import com.example.lab1.R
import com.example.lab1.databinding.FragmentDbBinding
import com.example.lab1.viewModel.FragmentDbViewModel

class FragmentDb : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val binding: FragmentDbBinding = DataBindingUtil.inflate(inflater, R.layout.fragment_db, container, false)
        binding.viewModel = FragmentDbViewModel(activity!!.application)
        binding.lifecycleOwner = this
        return binding.root
    }
}