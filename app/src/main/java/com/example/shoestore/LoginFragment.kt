package com.example.shoestore

import android.content.SharedPreferences
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.databinding.DataBindingUtil
import androidx.navigation.fragment.findNavController
import com.example.shoestore.databinding.FragmentLoginBinding
import com.google.android.material.textfield.TextInputEditText
import com.google.android.material.textfield.TextInputLayout

class LoginFragment : Fragment() {

    private lateinit var binding : FragmentLoginBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentLoginBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.apply{
            loginButton.setOnClickListener {
                if(checkEmailAndPasswordNotEmpty()){
                    findNavController().navigate(LoginFragmentDirections.actionLoginFragmentToWelcomeFragment())
                }
            }

            signUpButton.setOnClickListener {
                if(checkEmailAndPasswordNotEmpty()){
                    findNavController().navigate(LoginFragmentDirections.actionLoginFragmentToWelcomeFragment())
                }
            }
        }

    }

    private fun checkEmailAndPasswordNotEmpty(): Boolean{
        var allGood = true
        binding.apply{
            if(emailText.text.isNullOrBlank()){
                emailTextBox.error = getString(R.string.empty_email_error)
                allGood = false
            }
            else{
                emailTextBox.error = null
            }
            if(passwordText.text.isNullOrBlank()){
                passwordTextBox.error = getString(R.string.empty_password_error)
                passwordTextBox.errorIconDrawable = null
                allGood = false
            }
            else{
                passwordTextBox.error = null
            }
            invalidateAll()
        }
        return allGood
    }

}