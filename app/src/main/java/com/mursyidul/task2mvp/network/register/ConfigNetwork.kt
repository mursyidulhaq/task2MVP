package com.mursyidul.task2mvp.network.register

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class ConfigNetwork {
    companion object{
        fun getRetrofit(): UserService
        {
            val retrofit :Retrofit = Retrofit.Builder()
                .baseUrl("http://192.168.43.151/task2MVP/")
                .addConverterFactory(GsonConverterFactory.create())
                .build()
            val service = retrofit.create(UserService::class.java)
            return service
        }
    }
}