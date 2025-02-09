package com.example.membershipRegistrationScreen

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.membershipRegistrationScreen.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding : ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // apply 블록을 활용해 뷰의 속성을 설정
        binding.apply {
            // EditText들의 추가 설정 (XML에 기본 값이 있으므로 필요에 따라 재설정)
            nameEditText.apply {
                hint = resources.getString(R.string.name)
            }
            emailEditText.apply {
                hint = resources.getString(R.string.email)
            }
            passwordEditText.apply {
                hint = resources.getString(R.string.password)
            }
            confirmPasswordEditText.apply {
                hint = resources.getString(R.string.confirm_password)
            }

            // 버튼 속성 및 클릭 리스너 설정
            createAccountButton.apply {
                text = resources.getString(R.string.create_account)
                setOnClickListener {
                    val password = passwordEditText.text.toString()
                    val confirmPassword = confirmPasswordEditText.text.toString()

                    // 비밀번호 확인 검사
                    if (password != confirmPassword) {
                        Toast.makeText(
                            this@MainActivity,
                            "비밀번호가 일치하지 않습니다",
                            Toast.LENGTH_SHORT
                        ).show()
                    } else {
                        // 비밀번호가 일치할 경우 회원가입 성공 후 EditText 초기화 (빈 칸으로 변경)
                        nameEditText.text.clear()
                        emailEditText.text.clear()
                        passwordEditText.text.clear()
                        confirmPasswordEditText.text.clear()

                        // 성공 메시지 출력 (필요 시)
                        Toast.makeText(
                            this@MainActivity,
                            "회원가입 성공",
                            Toast.LENGTH_SHORT
                        ).show()
                    }
                }
            }
        }
    }
}