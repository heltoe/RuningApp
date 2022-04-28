package com.example.runingapp.ui.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.example.runingapp.R
import com.example.runingapp.databinding.FragmentSettingsBinding
import com.example.runingapp.ui.viewmodels.StatisticsViewModel

class SettingsFragment: Fragment(R.layout.fragment_settings) {
    private var _binding: FragmentSettingsBinding? = null
    val mBinding get() = _binding!!
    private val viewModel: StatisticsViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentSettingsBinding.inflate(layoutInflater, container, false)
        return mBinding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}