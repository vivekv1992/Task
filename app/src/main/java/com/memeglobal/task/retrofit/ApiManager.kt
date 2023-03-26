package com.memeglobal.task.retrofit

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class ApiManager {
  private var service:ApiInterface? = null

    fun getService(): ApiInterface?{
        if (this.service == null){
            this.service = Retrofit.Builder().baseUrl(Constant.Base_URL).addConverterFactory(GsonConverterFactory.create()).build().create(ApiInterface::class.java)
        }
        return this.service
    }
}

