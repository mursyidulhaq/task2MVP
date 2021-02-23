package com.mursyidul.task2mvp.model.hutang.getData

import com.google.gson.annotations.SerializedName

data class ResponseSeverGetDataHutang(

	@field:SerializedName("data")
	val data: List<DataItem>? = null,

	@field:SerializedName("message")
	val message: String? = null,

	@field:SerializedName("isSuccess")
	val isSuccess: Boolean? = null
)


