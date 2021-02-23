package com.mursyidul.task2mvp.network.hutang

import com.mursyidul.task2mvp.network.login.LoginService
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class ConfigNetworkHutang {
    companion object{
        fun getRetrofit(): HutangService
        {
            val retrofit : Retrofit = Retrofit.Builder()
                .baseUrl("http://192.168.43.151/task2MVP/")
                .addConverterFactory(GsonConverterFactory.create())
                .build()
            val service = retrofit.create(HutangService::class.java)
            return service
        }
    }
}