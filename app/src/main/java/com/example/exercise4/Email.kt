package com.example.exercise4

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import kotlinx.android.synthetic.main.activity_email.*

class Email : AppCompatActivity() {
    var number: Int = 30
    lateinit var sharedPreferences: SharedPreferences
    lateinit var editor: SharedPreferences.Editor
    private var hand = Handler()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_email)
        RuntoZero()
        sharedPreferences = getSharedPreferences("SHARED_PERF", Context.MODE_PRIVATE)
        editor = sharedPreferences.edit()
        btnResend.setOnClickListener {
            editor.putString("password", "123")
            editor.commit()
            hand.removeCallbacks(runnable)
            finish()
            val intent = Intent(this, ConfirmPasswordChanged::class.java)
            startActivity(intent)
        }
    }

    var runnable = Runnable {
        if (number > 0) {
            number--
            tvWait.setText("Wait " + number + " seconds before sending it")
            RuntoZero()
        }
    }

    fun RuntoZero() {
        hand.postDelayed(runnable, 1000)
        if (number == 0) {
            editor.putString("password", "123")
            editor.commit()
            hand.removeCallbacks(runnable)
            finish()
            val intent = Intent(this, ConfirmPasswordChanged::class.java)
            startActivity(intent)
        }
    }
}