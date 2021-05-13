package com.example.exercise4

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.exercise4.fragment.Home
import com.example.exercise4.fragment.OnBoarding1

class MainActivity : AppCompatActivity() {
    lateinit var sharedPreferences:SharedPreferences
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        sharedPreferences = getSharedPreferences("SHARED_PERF", Context.MODE_PRIVATE)
        var tutorial: String? = sharedPreferences.getString("check","")
        if(tutorial.equals("true")){
            finish()
            val intent = Intent(this,Login::class.java)
            startActivity(intent)
        }else{
            val onBoarding1 = OnBoarding1()
            val support = supportFragmentManager.beginTransaction()
            support.replace(R.id.container,onBoarding1)
            support.addToBackStack(null)
            support.commit()
        }


    }

    override fun onBackPressed() {
        super.onBackPressed()
        if (supportFragmentManager.backStackEntryCount == 0){
            finish()
        }
    }
}