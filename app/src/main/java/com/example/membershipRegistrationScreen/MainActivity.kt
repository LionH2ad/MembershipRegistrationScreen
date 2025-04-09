package com.example.membershipRegistrationScreen

import android.os.Bundle
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.example.membershipRegistrationScreen.databinding.ActivityMainBinding
import com.example.membershipRegistrationScreen.viewmodel.MainViewModel

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private val viewModel: MainViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setupEditTexts()
        setupObservers()
        setupSignUpButton()
    }

    private fun setupEditTexts() = with(binding) {
        nameEditText.hint = getString(R.string.name)
        emailEditText.hint = getString(R.string.email)
        passwordEditText.hint = getString(R.string.password)
        confirmPasswordEditText.hint = getString(R.string.confirm_password)
    }

    private fun setupSignUpButton() = with(binding) {
        createAccountButton.setOnClickListener {
            viewModel.onSignUpClicked(
                name = nameEditText.text.toString(),
                email = emailEditText.text.toString(),
                password = passwordEditText.text.toString(),
                confirmPassword = confirmPasswordEditText.text.toString()
            )
        }
    }

    private fun setupObservers() {
        viewModel.toastMessage.observe(this) { message ->
            Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
        }

        viewModel.clearInputs.observe(this) { shouldClear ->
            if (shouldClear) {
                binding.nameEditText.text.clear()
                binding.emailEditText.text.clear()
                binding.passwordEditText.text.clear()
                binding.confirmPasswordEditText.text.clear()
            }
        }
    }
}
