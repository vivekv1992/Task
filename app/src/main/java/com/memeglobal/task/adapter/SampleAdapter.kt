package com.memeglobal.task.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.memeglobal.task.databinding.ItemsBinding
import com.memeglobal.task.model.ImageResponse

class SampleAdapter(val items: ArrayList<ImageResponse>):RecyclerView.Adapter<SampleAdapter.ViewHolder>() {
    inner class ViewHolder(var binding: ItemsBinding):RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = ItemsBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        TODO("Not yet implemented")
    }

    override fun getItemCount(): Int {
        TODO("Not yet implemented")
    }
}