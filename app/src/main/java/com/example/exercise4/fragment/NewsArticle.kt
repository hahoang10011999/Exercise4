package com.example.exercise4.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.exercise4.R
import kotlinx.android.synthetic.main.activity_news_article.view.*

class NewsArticle : Fragment() {
    var title: String? = ""
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.activity_news_article, container, false)
        title = arguments?.getString("title")
        view.tvTitle.text = title
        view.imgBack.setOnClickListener {
            val news = News()
            fragmentManager?.beginTransaction()
                ?.replace(R.id.container, news)
                ?.commit()
        }
        return view
    }
}