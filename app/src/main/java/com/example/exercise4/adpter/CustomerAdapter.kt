package com.example.exercise4.adpter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.exercise4.ItemCustomer
import com.example.exercise4.R
import kotlinx.android.synthetic.main.item_content.view.*
import kotlinx.android.synthetic.main.item_content_1.view.*
import kotlinx.android.synthetic.main.item_title_customer.view.*

private const val CONTEN1_TYPE = 1
private const val CONTEN_TYPE = 0

class CustomerAdapter(var list: MutableList<ItemCustomer>) :
    RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        if (viewType == CONTEN_TYPE) {
            val view =
                LayoutInflater.from(parent.context).inflate(R.layout.item_content, parent, false)
            val viewHolder = ContentHolder(view)
            return viewHolder
        } else if (viewType == CONTEN1_TYPE) {
            val view =
                LayoutInflater.from(parent.context).inflate(R.layout.item_content_1, parent, false)
            val viewHolder = Content1Holder(view)
            return viewHolder
        } else {
            val view = LayoutInflater.from(parent.context)
                .inflate(R.layout.item_title_customer, parent, false)
            val viewHolder = TitleHolder(view)
            return viewHolder
        }
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        if (list[position].type == CONTEN_TYPE) {
            (holder as ContentHolder).bind(position)
        } else if (list[position].type == CONTEN1_TYPE) {
            (holder as Content1Holder).bind(position)
        } else {
            (holder as TitleHolder).bind(position)
        }
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun getItemViewType(position: Int): Int {
        return list[position].type
    }

    inner class ContentHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val tvContent = itemView.tvContent
        val imgContent = itemView.imgContent
        fun bind(position: Int) {
            var item = list[position]
            tvContent.text = item.text
            imgContent.setImageResource(item.img)
        }
    }

    inner class Content1Holder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val tvContent1 = itemView.tvContent1
        val imgContent1 = itemView.imgContent1
        fun bind(position: Int) {
            var item = list[position]
            tvContent1.text = item.text
            imgContent1.setImageResource(item.img)
        }
    }

    inner class TitleHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val tvTitle = itemView.tvTitle
        fun bind(position: Int) {
            var item = list[position]
            tvTitle.text = item.text
        }
    }
}