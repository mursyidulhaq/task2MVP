package com.mursyidul.task2mvp.network.register

import com.mursyidul.task2mvp.model.register.ResponseServerRegister
import retrofit2.Call
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.POST

interface UserService {
    @FormUrlEncoded
    @POST("register.php")
    fun register(
            @Field("nama")nama :String,
            @Field("email")email:String,
            @Field("password")password :String,
            @Field("passwordConfirm")paswordConform :String

    ):Call<ResponseServerRegister>
}