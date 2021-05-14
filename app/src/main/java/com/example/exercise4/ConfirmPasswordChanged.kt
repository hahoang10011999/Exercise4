package com.example.exercise4

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_confirm_password_changed.*

class ConfirmPasswordChanged : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_confirm_password_changed)
        btnLogin.setOnClickListener {
            finish()
            val intent = Intent(this, Login::class.java)
            startActivity(intent)
        }
    }

    override fun onBackPressed() {
        super.onBackPressed()
        this.finish()
        val intent = Intent(this, Email::class.java)
        startActivity(intent)
    }
}