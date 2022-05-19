package com.example.runingapp.ui.fragments

import android.content.SharedPreferences
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.example.runingapp.R
import com.example.runingapp.databinding.FragmentSettingsBinding
import com.example.runingapp.ui.MainActivity
import com.example.runingapp.ui.viewmodels.StatisticsViewModel
import com.example.runingapp.utils.Constants.KEY_NAME
import com.example.runingapp.utils.Constants.KEY_WEIGHT
import com.google.android.material.snackbar.Snackbar
import com.google.android.material.textview.MaterialTextView
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class SettingsFragment : Fragment(R.layout.fragment_settings) {
    private var _binding: FragmentSettingsBinding? = null
    val mBinding get() = _binding!!
    private val viewModel: StatisticsViewModel by viewModels()
    @Inject
    lateinit var sharedPref: SharedPreferences

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentSettingsBinding.inflate(layoutInflater, container, false)
        return mBinding.root
    }

    private fun applyChangesToSharedPref(): Boolean {
        val nameText = mBinding.etName.text.toString()
        val weightText = mBinding.etWeight.text.toString()
        if (nameText.isEmpty() || weightText.isEmpty()) {
            return false
        }
        sharedPref.edit()
            .putString(KEY_NAME, nameText)
            .putFloat(KEY_WEIGHT, weightText.toFloat())
            .apply()
        val toolbarText = "Let's go $nameText!"
        (activity as MainActivity).findViewById<MaterialTextView>(R.id.tvToolbarTitle).text = toolbarText
        return true
    }

    private fun loadFieldsFromSharedPreferences () {
        val name = sharedPref.getString(KEY_NAME, "")
        val weight = sharedPref.getFloat(KEY_WEIGHT, 80f)
        mBinding.etName.setText(name)
        mBinding.etWeight.setText(weight.toString())
    }

    override fun onStart() {
        super.onStart()
        loadFieldsFromSharedPreferences()
        mBinding.btnApplyChanges.setOnClickListener{
            val success = applyChangesToSharedPref()
            if (success) {
                view?.let {
                    Snackbar.make(it, "Saved changes", Snackbar.LENGTH_LONG).show()
                }
            } else {
                view?.let {
                    Snackbar.make(it, "Please fill out all the fields", Snackbar.LENGTH_LONG).show()
                }
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}