package com.mursyidul.task2mvp.model.register

import com.google.gson.annotations.SerializedName

data class ResponseServerRegister(

	@field:SerializedName("message")
	val message: String? = null,

	@field:SerializedName("isSuccess")
	val isSuccess: Boolean? = null
)
