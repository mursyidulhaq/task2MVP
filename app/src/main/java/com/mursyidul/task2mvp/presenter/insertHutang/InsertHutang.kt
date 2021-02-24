package com.mursyidul.task2mvp.presenter.insertHutang

import com.mursyidul.task2mvp.model.hutang.insert.ResponseServerInsertHutang
import com.mursyidul.task2mvp.network.hutang.ConfigNetworkHutang
import retrofit2.Call
import retrofit2.Response

class InsertHutang(val insertView :InsertHutangInterface) {

   fun insert( nama :String, nohp :String, tgl_pinjam:String, tgl_kembali :String)
   {
       ConfigNetworkHutang.getRetrofit().insert(nama,nohp,tgl_pinjam,tgl_kembali)
               .enqueue(object :retrofit2.Callback<ResponseServerInsertHutang>{
                   override fun onFailure(call: Call<ResponseServerInsertHutang>, t: Throwable) {
                       insertView.isErrorInser(t.localizedMessage)
                   }

                   override fun onResponse(call: Call<ResponseServerInsertHutang>, response: Response<ResponseServerInsertHutang>) {
                       if (response.isSuccessful) {
                           val responseServer = response.body()
                           val message = response.body()?.message
                           val status = response.body()?.isSuccess
                           if (status ?: true) {
                               responseServer?.let {insertView.onResponseInsert(it) }
                           } else {
                               insertView.isErrorInser("response failure")
                           }

                       }
                   }
               })
   }

    fun update(id:String,nama :String, nohp :String, tgl_pinjam:String, tgl_kembali :String)
    {
        ConfigNetworkHutang.getRetrofit().update(id,nama,nohp,tgl_pinjam,tgl_kembali)
                .enqueue(object :retrofit2.Callback<ResponseServerInsertHutang>{
                    override fun onFailure(call: Call<ResponseServerInsertHutang>, t: Throwable) {
                        insertView.isErrorInser(t.localizedMessage)
                    }

                    override fun onResponse(call: Call<ResponseServerInsertHutang>, response: Response<ResponseServerInsertHutang>) {
                        if (response.isSuccessful) {
                            val responseServer = response.body()
                            val message = response.body()?.message
                            val status = response.body()?.isSuccess
                            if (status ?: true) {
                                responseServer?.let {insertView.onResponseInsert(it) }
                            } else {
                                insertView.isErrorInser("response failure")
                            }

                        }
                    }
                })
    }
}