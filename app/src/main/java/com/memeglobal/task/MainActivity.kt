package com.memeglobal.task

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.memeglobal.task.adapter.TaskAdapter
import com.memeglobal.task.databinding.ActivityMainBinding
import com.memeglobal.task.model.ImageResponse
import com.memeglobal.task.retrofit.ApiManager
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {
    private val manager = ApiManager()
    lateinit var binding: ActivityMainBinding
    var items: ArrayList<ImageResponse> = ArrayList()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.recyclerview.layoutManager = LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false)
        getImage()
    }

    fun getImage(){
        CoroutineScope(Dispatchers.Main).launch {
            try {
                val response = fetchData()
                println("MainActivity.getImage dataFetched")
                if (response != null) {
                    binding.recyclerview.adapter = TaskAdapter(response, this@MainActivity)
                }
            } catch (ex : Exception){
                println("MainActivity.getImage ${ex.message}")
            }

        }

    }

    private suspend fun fetchData() : ImageResponse? {
        return manager.getService()?.getMovies("9c0523bff54071c4fb4b716a950231b9")
    }

}