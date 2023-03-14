package com.memeglobal.task

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.telecom.Call
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.memeglobal.task.adapter.TaskAdapter
import com.memeglobal.task.databinding.ActivityMainBinding
import com.memeglobal.task.model.ImageResponse
import com.memeglobal.task.retrofit.ApiManager
import retrofit2.Callback
import retrofit2.Response

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
        val call: retrofit2.Call<ImageResponse>? = manager.getService()?.getMovies("9c0523bff54071c4fb4b716a950231b9")
        call?.enqueue(object : Callback<ImageResponse>{
            override fun onResponse(
                call: retrofit2.Call<ImageResponse>,
                response: Response<ImageResponse>
            ) {
                if(response.isSuccessful && response.body()!=null){
                    val imageResponse = response.body()
                    if(imageResponse!= null){
                        items.add(imageResponse)
                        binding.recyclerview.adapter = TaskAdapter(imageResponse)
                    }
                }


                


            }

            override fun onFailure(call: retrofit2.Call<ImageResponse>, t: Throwable) {
                TODO("Not yet implemented")
            }

        })




    }






}