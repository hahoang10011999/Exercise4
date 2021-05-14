package com.example.exercise4.fragment

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.exercise4.Communicator
import com.example.exercise4.ItemNews
import com.example.exercise4.R
import com.example.exercise4.adpter.HomeAdapter
import com.example.exercise4.adpter.NewsAdapter
import kotlinx.android.synthetic.main.activity_home.*
import kotlinx.android.synthetic.main.activity_main_screen.*
import kotlinx.android.synthetic.main.activity_news.*

class News : Fragment(),NewsAdapter.OnItemClickListener {
    lateinit var adapter: NewsAdapter
    lateinit var list: MutableList<ItemNews>
    lateinit var layoutManager: LinearLayoutManager
    private lateinit var communicator: Communicator
    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        layoutManager = LinearLayoutManager(context)
        rvNews.layoutManager = layoutManager
        addItem()
        adapter = NewsAdapter(list,this)
        rvNews.adapter = adapter
        imgBack.setOnClickListener {
            fragmentManager?.popBackStack()
        }
        communicator = activity as Communicator

        activity?.imgCustomer?.clearColorFilter()
        activity?.imgCoin?.clearColorFilter()

        activity?.imgNews?.setColorFilter(resources.getColor(R.color.colorWhile))
        activity?.imgHome?.setColorFilter(R.color.colorN)

        activity?.imgNews?.setBackgroundResource(R.drawable.cus_item_nav)
        activity?.imgCoin?.background = null
        activity?.imgCustomer?.background = null
        activity?.imgHome?.background = null
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.activity_news, container, false)
        list = mutableListOf()
        return view
    }

    fun addItem() {
        var item = ItemNews(
            R.drawable.img_item_news,
            "ALT -3,87%",
            "3 Sept 2020",
            "ATLANTIA",
            "Illum velit nam voluptatum enim aut " +
                    " ratione ratione officiis totam." +
                    "Mollitia eum sint tempora ducimus"
        )
        var item1 = ItemNews(
            R.drawable.img_item_news1,
            "HKD -2,13%",
            "2 Sept 2020",
            "XIAOMI",
            "Illum velit nam voluptatum enim aut " +
                    " ratione ratione officiis totam." +
                    "Mollitia eum sint tempora ducimus"
        )
        var item2 = ItemNews(
            R.drawable.img_item_news,
            "AAPL -0,91%",
            "1 Sept 2020",
            "APPLE",
            "Illum velit nam voluptatum enim aut " +
                    " ratione ratione officiis totam." +
                    "Mollitia eum sint tempora ducimus"
        )
        list.add(item)
        list.add(item1)
        list.add(item2)
    }

    override fun onItemClick(position: Int) {
        val title = list[position].name
        communicator.sendData(title)
    }
}