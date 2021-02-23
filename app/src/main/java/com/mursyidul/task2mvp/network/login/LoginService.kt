package com.mursyidul.task2mvp.network.login

import com.mursyidul.task2mvp.model.login.ResponseServerLogin
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface LoginService {
    @GET("login.php")
    fun login(@Query("email")email :String,
                @Query("passwordd")password :String):Call<ResponseServerLogin>
}