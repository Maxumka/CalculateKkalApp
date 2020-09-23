package com.example.lab1.view

import android.os.Bundle
import androidx.preference.PreferenceFragmentCompat
import com.example.lab1.R

class FragmentSettings : PreferenceFragmentCompat() {

    override fun onCreatePreferences(savedInstanceState: Bundle?, rootKey: String?) {
        setPreferencesFromResource(R.xml.root_preferences, rootKey)
    }
}