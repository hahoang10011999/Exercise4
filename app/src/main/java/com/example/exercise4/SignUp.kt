package com.example.exercise4

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_sign_up.*

class SignUp : AppCompatActivity() {
    lateinit var sharedPreferences: SharedPreferences
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_up)
        sharedPreferences = getSharedPreferences("SHARED_PERF", Context.MODE_PRIVATE)
        var editor = sharedPreferences.edit()
        btnSignUp.setOnClickListener {
            var email: String = edEmail.text.toString()
            var pass: String = edPassword.text.toString()
            if (email.isEmpty() || pass.isEmpty()) {
                Toast.makeText(
                    this@SignUp,
                    "Vui lòng nhập đầy đủ tài khoản và mật khẩu!!!",
                    Toast.LENGTH_LONG
                ).show()
            } else {
                editor.putString("account", email)
                editor.putString("password", pass)
                editor.commit()
            }
        }
        tvForgotPassword.setOnClickListener {
            //finish()
            val intent = Intent(this, Email::class.java)
            startActivity(intent)
        }
        tvLogin.setOnClickListener {
            finish()
            val intent = Intent(this, Login::class.java)
            startActivity(intent)
        }
    }

    override fun onBackPressed() {
        super.onBackPressed()
        finish()
        val intent = Intent(this, Login::class.java)
        startActivity(intent)
    }
}