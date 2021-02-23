package com.mursyidul.task2mvp.network.login

import com.mursyidul.task2mvp.network.register.UserService
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class ConfigNetworkLogin {

    companion object{
        fun getRetrofit(): LoginService
        {
            val retrofit : Retrofit = Retrofit.Builder()
                    .baseUrl("http://192.168.43.151/task2MVP/")
                    .addConverterFactory(GsonConverterFactory.create())
                    .build()
            val service = retrofit.create(LoginService::class.java)
            return service
        }
    }
}