package com.example.exercise4.fragment

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.exercise4.Login
import com.example.exercise4.R
import kotlinx.android.synthetic.main.activity_on_boarding3.view.*
import java.util.prefs.Preferences

class OnBoarding3 : Fragment() {
    lateinit var sharedPreferences:SharedPreferences
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val view = inflater.inflate(R.layout.activity_on_boarding3, container, false)
        sharedPreferences = activity!!.getSharedPreferences("SHARED_PERF", Context.MODE_PRIVATE)
        var editor = sharedPreferences.edit()
        view.imgBack.setOnClickListener {
            val s = fragmentManager
            s?.popBackStack()
        }
        view.btnStart.setOnClickListener {
            editor.putString("check","true")
            editor.commit()
            this.activity?.finish()
            val intent = Intent(this.activity, Login::class.java)
            startActivity(intent)
        }
        view.tvSkip.setOnClickListener {
            this.activity?.finish()
            val intent = Intent(this.activity, Login::class.java)
            startActivity(intent)
        }
        return view
    }
}