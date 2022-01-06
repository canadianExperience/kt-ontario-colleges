package com.me.kt_ontario_colleges.ui.campuses.view

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.me.kt_ontario_colleges.R
import com.me.kt_ontario_colleges.room.entity.Campus

class CampusesRecyclerViewAdapter : RecyclerView.Adapter<CampusesRecyclerViewAdapter.CampusViewHolder>() {
    class CampusViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)

    private val diffUtil = object : DiffUtil.ItemCallback<Campus>(){
        override fun areItemsTheSame(oldItem: Campus, newItem: Campus): Boolean {
            return oldItem == newItem
        }

        override fun areContentsTheSame(oldItem: Campus, newItem: Campus): Boolean {
            return oldItem == newItem
        }
    }

    private val listDiffer = AsyncListDiffer(this, diffUtil)

    var campuses: List<Campus>
        get() = listDiffer.currentList
        set(value) = listDiffer.submitList(value)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CampusViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.campus_row, parent, false)
        return CampusViewHolder(view)
    }

    override fun onBindViewHolder(holder: CampusViewHolder, position: Int) {
        val name = holder.itemView.findViewById<TextView>(R.id.name)
        val college = campuses[position]

        holder.itemView.apply {
            name.text = college.name
        }
    }

    override fun getItemCount(): Int {
        return campuses.size
    }
}