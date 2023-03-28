package com.memeglobal.task.retrofit

import com.memeglobal.task.model.ImageResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiInterface {
    @GET("/3/movie/upcoming")
    suspend fun getMovies(@Query("api_key") api_key: String?): ImageResponse

}



