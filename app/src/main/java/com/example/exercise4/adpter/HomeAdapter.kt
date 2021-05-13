package com.example.exercise4.adpter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.exercise4.ItemHome
import com.example.exercise4.R
import com.example.exercise4.adpter.HomeAdapter.ViewHolder
import java.util.ArrayList

class HomeAdapter(var list: MutableList<ItemHome>) : RecyclerView.Adapter<ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        var layoutInflater = LayoutInflater.from(parent.context)
        var view: View = layoutInflater.inflate(R.layout.item_home, parent, false)
        var viewHolder = HomeAdapter.ViewHolder(view)
        return viewHolder
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.tvName.text = list.get(position).name +"\t"+ position.toString()
        holder.tvNumber.text = list.get(position).number
        holder.tvAddress.text = list.get(position).address
        holder.tvTime.text = list.get(position).time
        holder.tvPercen.text = list.get(position).percen
    }

    fun deleteItem(position: Int) {
        list.removeAt(position)
        notifyItemRemoved(position)
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val tvName = itemView.findViewById<TextView>(R.id.tvName)
        val tvNumber = itemView.findViewById<TextView>(R.id.tvNumber)
        val tvAddress = itemView.findViewById<TextView>(R.id.tvAddress)
        val tvTime = itemView.findViewById<TextView>(R.id.tvTime)
        val tvPercen = itemView.findViewById<TextView>(R.id.tvPercen)
    }
}