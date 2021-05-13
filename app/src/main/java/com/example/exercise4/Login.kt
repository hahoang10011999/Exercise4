package com.example.exercise4

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import com.example.exercise4.fragment.Home
import kotlinx.android.synthetic.main.activity_login.*

class Login : AppCompatActivity() {
    lateinit var perferences: SharedPreferences
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        perferences = getSharedPreferences("SHARED_PERF", Context.MODE_PRIVATE)
        val acc: String? = perferences.getString("account", "")
        val pass: String? = perferences.getString("password", "")
        edEmail.setText(acc)
        edPassword.setText(pass)
        btnLogin.setOnClickListener {
            if (edEmail.text.isEmpty() || edPassword.text.isEmpty()) {
                Toast.makeText(
                    this@Login,
                    "Bạn chưa nhập tài khoản hoặc mật khẩu !!!",
                    Toast.LENGTH_LONG
                ).show()
            } else {
                var email: String = edEmail.text.toString()
                var password: String = edPassword.text.toString()
                Log.d("AAA", email + "   " + password)
                if (!email.equals(acc) || !password.equals(pass)) {
                    Toast.makeText(
                        this@Login,
                        "Tài khoản hoặc mật khẩu chưa chính xác !!!",
                        Toast.LENGTH_LONG
                    ).show()
                } else {
                    finish()
                    val intent = Intent(this, MainScreen::class.java)
                    startActivity(intent)
                }
            }
        }
        tvSignUp.setOnClickListener {
             finish()
            val intent = Intent(this, SignUp::class.java)
            startActivity(intent)
        }
        tvForgotPassword.setOnClickListener {
            //finish()
            val intent = Intent(this, Email::class.java)
            startActivity(intent)
        }
    }
}