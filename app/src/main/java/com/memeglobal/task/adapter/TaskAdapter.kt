package com.memeglobal.task.adapter

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.memeglobal.task.MainActivity
import com.memeglobal.task.databinding.ActivityMainBinding
import com.memeglobal.task.databinding.ItemsBinding
import com.memeglobal.task.model.ImageResponse
import com.squareup.picasso.Picasso

class TaskAdapter(val items: ImageResponse,val context: Context): RecyclerView.Adapter<TaskAdapter.ViewHolder>() {
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
        holder.binding.textView2.setText(data?.title)
        holder.itemView.setOnClickListener{
            val intent  = Intent(context, MainActivity::class.java)
            context.startActivity(intent)
        }
    }

    override fun getItemCount(): Int {
      return items.results?.size?:0
    }
}