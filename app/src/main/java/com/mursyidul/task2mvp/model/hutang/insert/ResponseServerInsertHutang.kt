package com.mursyidul.task2mvp.model.hutang.insert

import com.google.gson.annotations.SerializedName

data class ResponseServerInsertHutang(

	@field:SerializedName("message")
	val message: String? = null,

	@field:SerializedName("isSuccess")
	val isSuccess: Boolean? = null
)
