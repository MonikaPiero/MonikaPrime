package com.example.monikaprime.login


import android.content.SharedPreferences
import android.os.Bundle
import android.preference.PreferenceManager
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import com.example.monikaprime.R
import com.example.monikaprime.utils.put
import kotlinx.android.synthetic.main.fragment_first_setting_page.*


class FirstSettingPageFragment : Fragment(R.layout.fragment_first_setting_page) {
    private val preferences: SharedPreferences by lazy {
        PreferenceManager.getDefaultSharedPreferences(
            activity
        )
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        savesetting.setOnClickListener {
            view.findNavController().navigate(R.id.action_firstSettingPageFragment2_to_mainFragment)
        }
        preferences.put("FirstTimeLogin", true)
    }

}
