package com.example.membershipRegistrationScreen.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MainViewModel : ViewModel() {

    private val _toastMessage = MutableLiveData<String>()
    val toastMessage: LiveData<String> get() = _toastMessage

    private val _clearInputs = MutableLiveData<Boolean>()
    val clearInputs: LiveData<Boolean> get() = _clearInputs

    fun onSignUpClicked(name: String, email: String, password: String, confirmPassword: String) {
        if (!isInputValid(name, email, password, confirmPassword)) {
            _toastMessage.value = "모든 항목을 입력해주세요"
            return
        }

        if (!isPasswordMatching(password, confirmPassword)) {
            _toastMessage.value = "비밀번호가 일치하지 않습니다"
            return
        }

        _toastMessage.value = "회원가입 성공"
        _clearInputs.value = true
    }

    private fun isInputValid(name: String, email: String, password: String, confirmPassword: String): Boolean {
        return name.isNotBlank() && email.isNotBlank() && password.isNotBlank() && confirmPassword.isNotBlank()
    }

    private fun isPasswordMatching(password: String, confirmPassword: String): Boolean {
        return password == confirmPassword
    }
}
