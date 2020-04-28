package com.example.monikaprime.login


import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.navigation.findNavController
import com.example.monikaprime.R
import com.example.monikaprime.main.ViewModelFactory
import kotlinx.android.synthetic.main.fragment_login_ip.*


class LoginIpFragment : Fragment(R.layout.fragment_login_ip) {
    lateinit var viewModel: LoginViewModel
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        sign_in.setOnClickListener { viewModel.authenticate(password.text.toString(),password.text.toString()) }
        viewModel = ViewModelProviders.of(this, activity?.let { ViewModelFactory(it) })
            .get(LoginViewModel::class.java)
//        viewModel = getViewModel()
        viewModel.authenticationState.observe(viewLifecycleOwner, Observer { authenticationState ->
            when (authenticationState) {
                LoginViewModel.AuthenticationState.NOT_REQUIRED -> view.findNavController().navigate(
                    R.id.action_loginIpFragment_to_mainFragment
                )
                LoginViewModel.AuthenticationState.AUTHENTICATED -> view.findNavController().navigate(
                    R.id.action_loginIpFragment_to_firstSettingPageFragment22
                )
                LoginViewModel.AuthenticationState.INVALID_AUTHENTICATION -> showErrorMessage()
            }
        })
    }


    private fun showErrorMessage() {

    }
}
