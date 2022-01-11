package com.me.kt_ontario_colleges.ui.colleges.view

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.RequestManager
import com.me.kt_ontario_colleges.R
import com.me.kt_ontario_colleges.room.entity.College
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

class CollegesRecyclerViewAdapter : RecyclerView.Adapter<CollegesRecyclerViewAdapter.CollegeViewHolder>() {
    class CollegeViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)

    private var onItemClickListener: ((Pair<Long, Int>) -> Unit) ?= null

    fun setOnItemClickListener(listener : (Pair<Long, Int>) -> Unit){
        onItemClickListener = listener
    }

    private val diffUtil = object : DiffUtil.ItemCallback<College>(){
        override fun areItemsTheSame(oldItem: College, newItem: College): Boolean {
            return oldItem == newItem
        }

        override fun areContentsTheSame(oldItem: College, newItem: College): Boolean {
            return oldItem == newItem
        }
    }

    private val listDiffer = AsyncListDiffer(this, diffUtil)

    var colleges: List<College>
        get() = listDiffer.currentList
        set(value) = listDiffer.submitList(value)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CollegeViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.college_row, parent, false)
        return CollegeViewHolder(view)
    }

    override fun onBindViewHolder(holder: CollegeViewHolder, position: Int) {
        val name = holder.itemView.findViewById<TextView>(R.id.name)
        val logo = holder.itemView.findViewById<ImageView>(R.id.logo)
        val college = colleges[position]

        holder.itemView.apply {
            name.text = college.name
           // glide.load(college.logo).into(logo)
            logo.setImageResource(college.logo)

            this.setOnClickListener {
                onItemClickListener?.let {
                    it(
                        Pair(college.id, college.logo)
                    )
                }
            }
        }
    }

    override fun getItemCount(): Int {
        return colleges.size
    }
}