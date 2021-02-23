package com.mursyidul.task2mvp.model.login

import com.google.gson.annotations.SerializedName

data class DataItem(

    @field:SerializedName("passwordd")
    val passwordd: String? = null,

    @field:SerializedName("nama")
    val nama: String? = null,

    @field:SerializedName("id_user")
    val idUser: String? = null,

    @field:SerializedName("email")
    val email: String? = null
)
