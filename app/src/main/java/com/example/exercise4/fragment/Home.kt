package com.example.exercise4.fragment

import android.content.res.ColorStateList
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.exercise4.ItemHome
import com.example.exercise4.R
import com.example.exercise4.SwipeToDelete
import com.example.exercise4.adpter.HomeAdapter
import kotlinx.android.synthetic.main.activity_home.*
import kotlinx.android.synthetic.main.activity_main_screen.*

class Home : Fragment() {
    lateinit var list: MutableList<ItemHome>
    lateinit var list1: MutableList<ItemHome>
    lateinit var adapter: HomeAdapter
    lateinit var layoutManager: LinearLayoutManager
    var check = true
    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        layoutManager = LinearLayoutManager(context)
        rvHome.layoutManager = layoutManager
        var divider = DividerItemDecoration(activity, layoutManager.orientation)
        rvHome.addItemDecoration(divider)
        addItem()
        adapter = HomeAdapter(list1)
        rvHome.adapter = adapter
        btnLoadMore.setOnClickListener {
            val visibleItemCount = layoutManager.childCount
            val pastVisibleItem = layoutManager.findFirstCompletelyVisibleItemPosition()
            val total = adapter.itemCount
            if ((visibleItemCount + pastVisibleItem) >= total) {
                getPage(list1)
            }
        }
        btnAlarm.setOnClickListener {
            if (check) {
                btnAlarm.setBackgroundResource(R.drawable.cus_botton_home_1)
                check = false
            } else {
                btnAlarm.setBackgroundResource(R.drawable.cus_button_home)
                check = true
            }
        }

        var itemTouchHelper = ItemTouchHelper(SwipeToDelete(adapter))
        itemTouchHelper.attachToRecyclerView(rvHome)

        activity?.imgHome?.clearColorFilter()
        activity?.imgNews?.clearColorFilter()
        activity?.imgCustomer?.clearColorFilter()
        activity?.imgCoin?.clearColorFilter()

        activity?.imgHome?.setBackgroundResource(R.drawable.cus_item_nav)
        activity?.imgCoin?.background = null
        activity?.imgNews?.background = null
        activity?.imgCustomer?.background = null
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.activity_home, container, false)
        list = mutableListOf()
        list1 = mutableListOf()
        return view
    }

    fun getPage(list: MutableList<ItemHome>) {
        addItem()
        Handler().postDelayed({
            if (::adapter.isInitialized) {
                adapter.notifyDataSetChanged()
            } else {
                adapter = HomeAdapter(list)
                rvHome.adapter = adapter
            }
        }, 2000)
    }

    fun addItem() {
        var item = ItemHome(
            "DOWN JONES",
            "NYSE",
            "10:44:45",
            "20.047.50",
            "+203(1,04%)"
        )
        var item1 = ItemHome(
            "FTSE100",
            "LONDON",
            "10:44:45",
            "20.047.50",
            "+203(1,04%)"
        )
        var item2 = ItemHome(
            "IBEX35",
            "MADRID",
            "10:44:45",
            "20.047.50",
            "+203(1,04%)"
        )
        var item3 = ItemHome(
            "DAX",
            "XETRA",
            "10:44:45",
            "20.047.50",
            "+203(1,04%)"
        )
        var item4 = ItemHome(
            "DOWN JONES",
            "NYSE",
            "10:44:45",
            "20.047.50",
            "+203(1,04%)"
        )
        var item5 = ItemHome(
            "FTSE100",
            "LONDON",
            "10:44:45",
            "20.047.50",
            "+203(1,04%)"
        )
        var item6 = ItemHome(
            "IBEX35",
            "MADRID",
            "10:44:45",
            "20.047.50",
            "+203(1,04%)"
        )
        var item7 = ItemHome(
            "DAX",
            "XETRA",
            "10:44:45",
            "20.047.50",
            "+203(1,04%)"
        )
        var item8 = ItemHome(
            "DOWN JONES",
            "NYSE",
            "10:44:45",
            "20.047.50",
            "+203(1,04%)"
        )
        var item9 = ItemHome(
            "FTSE100",
            "LONDON",
            "10:44:45",
            "20.047.50",
            "+203(1,04%)"
        )
        list.add(item)
        list.add(item1)
        list.add(item2)
        list.add(item3)
        list.add(item4)
        list.add(item5)
        list.add(item6)
        list.add(item7)
        list.add(item8)
        list.add(item9)
        for (i in 0..9) {
            list1.add(list.get(i))
        }
    }
}