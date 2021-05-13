package com.example.exercise4.fragment

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.exercise4.ItemCustomer
import com.example.exercise4.ItemNews
import com.example.exercise4.R
import com.example.exercise4.adpter.CustomerAdapter
import com.example.exercise4.adpter.NewsAdapter
import kotlinx.android.synthetic.main.activity_coin.*
import kotlinx.android.synthetic.main.activity_customer.*
import kotlinx.android.synthetic.main.activity_news.*

class Customer : Fragment() {
    lateinit var list: MutableList<ItemCustomer>
    lateinit var adapter: CustomerAdapter
    lateinit var layoutManager: LinearLayoutManager
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        layoutManager = LinearLayoutManager(context)
        recyclerView.layoutManager = layoutManager
        addItem()
        adapter = CustomerAdapter(list)
        recyclerView.adapter = adapter
        back.setOnClickListener {
            fragmentManager?.popBackStack()
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.activity_customer, container, false)
        list = mutableListOf()
        return view
    }

    fun addItem() {
        var item1 = ItemCustomer(0, "Alerts", R.drawable.icons_8_alarm)
        var item2 = ItemCustomer(0, "Predictions", R.drawable.icons_8_left_and_right_arrows)
        var item3 = ItemCustomer(0, "Saved elements", R.drawable.icons_8_pin)
        var item4 = ItemCustomer(0, "Remove Ads", R.drawable.icons_8_no_entry)
        var item5 = ItemCustomer(2, "Tools", 0)
        var item6 = ItemCustomer(1, "Select Stocks", R.drawable.icons_8_profit_2)
        var item7 = ItemCustomer(1, "Currency Exchange", R.drawable.icons_8_swap)
        var item8 = ItemCustomer(1, "Webinar", R.drawable.icons_8_video_call)
        var item9 = ItemCustomer(1, "Best Broker", R.drawable.icons_8_rent)
        var item10 = ItemCustomer(2, "Markets", 0)
        var item11 = ItemCustomer(1, "Select Stocks", R.drawable.icons_8_profit_2)
        list.add(item1)
        list.add(item2)
        list.add(item3)
        list.add(item4)
        list.add(item5)
        list.add(item6)
        list.add(item7)
        list.add(item8)
        list.add(item9)
        list.add(item10)
        list.add(item11)
    }
}