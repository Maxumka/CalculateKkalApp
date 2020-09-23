package com.example.lab1.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import com.example.lab1.R
import com.example.lab1.databinding.FragmentBrowserCallBinding
import com.example.lab1.viewModel.FragmentBrowserCallViewModel


class FragmentBrowserCall : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val binding: FragmentBrowserCallBinding = DataBindingUtil.inflate(inflater, R.layout.fragment_browser_call, container, false)
        binding.viewModel = FragmentBrowserCallViewModel(activity!!.application)
        binding.lifecycleOwner = this
        return binding.root
    }
}