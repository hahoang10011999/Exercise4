package com.example.exercise4.adpter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.exercise4.Communicator
import com.example.exercise4.ItemNews
import com.example.exercise4.R
import com.example.exercise4.adpter.NewsAdapter.ViewHolder
import kotlinx.android.synthetic.main.item_news.view.*

class NewsAdapter(
    private var list: MutableList<ItemNews>,
    private var listener: OnItemClickListener
) : RecyclerView.Adapter<ViewHolder>() {
    private lateinit var communicator: Communicator

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        var layoutInflater = LayoutInflater.from(parent.context)
        var view: View = layoutInflater.inflate(R.layout.item_news, parent, false)
        var viewHolder = ViewHolder(view)
        return viewHolder
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        var itemNews = list.get(position)
        holder.img.setImageResource(itemNews.img)
        holder.tvDate.setText(itemNews.date)
        holder.tvInfor.setText(itemNews.infor)
        holder.tvName.setText(itemNews.name)
        holder.tvPercen.setText(itemNews.percen)
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView),
        View.OnClickListener {
        val img = itemView.findViewById<ImageView>(R.id.img)
        val tvPercen = itemView.tvPercen
        val tvDate = itemView.tvDate
        val tvName = itemView.tvName
        val tvInfor = itemView.tvInfor
        val imgArrow = itemView.imgArrow

        init {
            imgArrow.setOnClickListener(this)
        }

        override fun onClick(p0: View?) {
            val position = adapterPosition
            if (position != RecyclerView.NO_POSITION) {
                listener.onItemClick(position)
            }
        }
    }

    interface OnItemClickListener {
        fun onItemClick(position: Int)
    }
}