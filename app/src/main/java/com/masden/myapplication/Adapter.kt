package com.masden.myapplication

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.list_huruf.view.*

class Adapter(private val listUser: ArrayList<DataModel>) : RecyclerView.Adapter<Adapter.viewHolder>(){

    class viewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var tvTitle: TextView = itemView.findViewById(R.id.tv_title)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): viewHolder {
        val view: View = LayoutInflater.from(parent.context).inflate(R.layout.list_huruf, parent, false)
        return viewHolder(view)
    }

    override fun onBindViewHolder(holder: viewHolder, position: Int) {
        val user = listUser[position]
        holder.tvTitle.text = user.title

    }

    override fun getItemCount(): Int = listUser.size

}