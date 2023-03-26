package com.memeglobal.task.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView.LayoutManager
import com.memeglobal.task.R
import com.memeglobal.task.adapter.SampleAdapter
import com.memeglobal.task.databinding.ActivityMainBinding
import com.memeglobal.task.databinding.ActivityRecyclerviewBinding
import com.memeglobal.task.model.ImageResponse
import com.memeglobal.task.retrofit.ApiManager
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class Recyclerview : AppCompatActivity() {

  private var manager = ApiManager()
    lateinit var binding: ActivityMainBinding
//    private val items:ArrayList<ImageResponse> = ArrayList()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.recyclerview.layoutManager = LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false)
        getData()
    }

    fun getData(){
        val call:Call<ImageResponse>? = manager.getService()?.getMovies("")
        call?.enqueue(object :Callback<ImageResponse>{
            override fun onResponse(call: Call<ImageResponse>, response: Response<ImageResponse>) {
               if (response.isSuccessful && response.body()!= null){
                   val response = response.body()
                   if (response!= null){
//                       items.add(response)
                       binding.recyclerview.adapter = SampleAdapter(response,this@Recyclerview)
                   }
               }
            }

            override fun onFailure(call: Call<ImageResponse>, t: Throwable) {
                TODO("Not yet implemented")
            }

        })
    }

//    fun getData(){
//        CoroutineScope(Dispatchers.Main).launch {
//            val result = manager.getService()?.getMovies("")
//
//            binding.recyclerview.adapter = SampleAdapter(result)
//        }
//    }
}