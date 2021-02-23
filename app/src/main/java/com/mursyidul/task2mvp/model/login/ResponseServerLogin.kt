package com.mursyidul.task2mvp.model.login

import com.google.gson.annotations.SerializedName

data class ResponseServerLogin(

	@field:SerializedName("data")
	val data: List<DataItem>? = null,

	@field:SerializedName("message")
	val message: String? = null,

	@field:SerializedName("isSuccess")
	val isSuccess: Boolean? = null
)

