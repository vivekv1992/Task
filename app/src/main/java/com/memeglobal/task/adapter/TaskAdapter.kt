package com.memeglobal.task.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.memeglobal.task.databinding.ActivityMainBinding
import com.memeglobal.task.databinding.ItemsBinding
import com.memeglobal.task.model.ImageResponse
import com.squareup.picasso.Picasso

class TaskAdapter(val items: ImageResponse): RecyclerView.Adapter<TaskAdapter.ViewHolder>() {
    inner class ViewHolder(var binding: ItemsBinding):RecyclerView.ViewHolder(binding.root){

    }



    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = ItemsBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
       val data = items.results?.get(position)
        val imgUrl = data?.backdrop_path
        Picasso.get().load("http://image.tmdb.org/t/p/w780$imgUrl").into(holder.binding.ImageView)
        holder.binding.textView1.setText(data?.original_language)
    }

    override fun getItemCount(): Int {
      return items.results?.size?:0
    }
}