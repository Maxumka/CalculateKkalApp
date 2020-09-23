package com.example.lab1.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import com.example.lab1.R
import com.example.lab1.databinding.FragmentFileServiceBinding
import com.example.lab1.viewModel.FragmentFileServiceViewModel

class FragmentFileService : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val binding: FragmentFileServiceBinding = DataBindingUtil.inflate(inflater, R.layout.fragment_file_service, container, false)
        binding.viewModel = FragmentFileServiceViewModel(activity!!.application)
        binding.lifecycleOwner = this
        return binding.root
    }
}