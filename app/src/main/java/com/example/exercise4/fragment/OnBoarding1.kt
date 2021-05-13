package com.example.exercise4.fragment

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.exercise4.Login
import com.example.exercise4.R
import kotlinx.android.synthetic.main.activity_on_boarding_1.view.*

class OnBoarding1 : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val view = inflater.inflate(R.layout.activity_on_boarding_1, container, false)
        val onBoarding2 = OnBoarding2()
        val support = fragmentManager?.beginTransaction()
        view.btnNext.setOnClickListener {
            support?.replace(R.id.container, onBoarding2)
            support?.addToBackStack(null)
            support?.commit()
        }
        view.tvSkip.setOnClickListener {
            this.activity?.finish()
            val intent = Intent(this.activity, Login::class.java)
            startActivity(intent)
        }
        return view
    }


}