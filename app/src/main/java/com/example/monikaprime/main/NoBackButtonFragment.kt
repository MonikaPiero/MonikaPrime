package com.example.monikaprime.main


import android.os.Bundle
import android.view.View
import androidx.activity.OnBackPressedCallback
import androidx.fragment.app.Fragment


abstract class NoBackButtonFragment(layout: Int) : Fragment(layout) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val onBackPressedCallback = object : OnBackPressedCallback(true) { override fun handleOnBackPressed() {} }

        requireActivity().getOnBackPressedDispatcher().addCallback(this, onBackPressedCallback)


    }


}
