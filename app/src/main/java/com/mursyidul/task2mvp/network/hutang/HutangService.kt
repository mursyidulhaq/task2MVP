package com.mursyidul.task2mvp.network.hutang

import com.mursyidul.task2mvp.model.hutang.getData.ResponseSeverGetDataHutang
import com.mursyidul.task2mvp.model.hutang.insert.ResponseServerInsertHutang
import retrofit2.Call
import retrofit2.http.*

interface HutangService {
    @FormUrlEncoded
    @POST("insertDataHutang.php")
    fun insert(
        @Field("nama_penghutang")nama_penghutang :String,
        @Field("nohp_penghutang")nohp_penghutang:String,
        @Field("tanggal_pinjam")tanggal_pinjam :String,
        @Field("tanggal_kembali")tanggal_kembali :String

    ): Call<ResponseServerInsertHutang>

    @GET("GetDataHutang.php")
    fun getData():Call<ResponseSeverGetDataHutang>

    @FormUrlEncoded
    @POST("UpdateDateHutang.php")
    fun update(
        @Field("id_hutang")id_hutang: String,
        @Field("nama_penghutang")nama_penghutang :String,
        @Field("nohp_penghutang")nohp_penghutang:String,
        @Field("tanggal_pinjam")tanggal_pinjam :String,
        @Field("tanggal_kembali")tanggal_kembali :String

    ): Call<ResponseServerInsertHutang>

    @FormUrlEncoded
    @POST("DeleteDataHutang.php")
    fun deleteData(@Field("id_hutang")id_hutang:String): Call<ResponseServerInsertHutang >
}