package com.example.exercise4.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.exercise4.R
import kotlinx.android.synthetic.main.activity_coin.*

class Coin : Fragment() {
    var check = true
    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        btnAlarm.setOnClickListener {
            if (check) {
                btnAlarm.setBackgroundResource(R.drawable.cus_button_coin)
                check = false
            } else {
                btnAlarm.setBackgroundResource(R.drawable.cus_button_circle)
                check = true
            }
        }
        imgBack.setOnClickListener {
            val s = fragmentManager
            s?.popBackStack()
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.activity_coin, container, false)
        return view
    }
}