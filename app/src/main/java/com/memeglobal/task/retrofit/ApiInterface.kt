package com.memeglobal.task.retrofit

import android.telecom.Call
import com.memeglobal.task.model.Dates
import com.memeglobal.task.model.ImageResponse
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Query

interface ApiInterface {
@GET("/3/movie/upcoming")
fun getMovies(@Query("api_key") api_key:String?): retrofit2.Call<ImageResponse>

}



