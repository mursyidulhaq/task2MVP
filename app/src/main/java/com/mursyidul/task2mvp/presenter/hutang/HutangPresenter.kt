package com.mursyidul.task2mvp.presenter.hutang

import com.mursyidul.task2mvp.model.hutang.getData.ResponseSeverGetDataHutang
import com.mursyidul.task2mvp.model.hutang.insert.ResponseServerInsertHutang
import com.mursyidul.task2mvp.network.hutang.ConfigNetworkHutang
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class HutangPresenter(var hutangView :HutangInterface) {
    fun getData()
    {
        ConfigNetworkHutang.getRetrofit().getData()
            .enqueue(object :Callback<ResponseSeverGetDataHutang>{
                override fun onFailure(call: Call<ResponseSeverGetDataHutang>, t: Throwable) {
                    hutangView .errorRegister(t.localizedMessage)
                }

                override fun onResponse(
                    call: Call<ResponseSeverGetDataHutang>,
                    response: Response<ResponseSeverGetDataHutang>
                ) {
                    if (response.isSuccessful) {
                        val responseServer = response.body()
                        val message = response.body()?.message
                        val status = response.body()?.isSuccess
                        if (status ?: true) {
                            responseServer?.let { hutangView.succecRegister(it) }
                        } else {
                            hutangView.errorRegister(message ?: "")
                        }

                    }
                }
            })


    }

    fun deleteHutang(id:String)
    {
        ConfigNetworkHutang.getRetrofit().deleteData(id)
            .enqueue(object :Callback<ResponseServerInsertHutang>{
                override fun onFailure(call: Call<ResponseServerInsertHutang>, t: Throwable) {
                    hutangView .errorRegister(t.localizedMessage)
                }

                override fun onResponse(
                    call: Call<ResponseServerInsertHutang>,
                    response: Response<ResponseServerInsertHutang>
                ) {
                    if (response.isSuccessful) {
                        val responseServer = response.body()
                        val message = response.body()?.message
                        val status = response.body()?.isSuccess
                        if (status ?: true) {
                            responseServer?.let { hutangView.delete(it) }
                        } else {
                            hutangView.errorRegister(message ?: "")
                        }

                    }
                }

            })
    }
}


