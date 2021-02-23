package com.mursyidul.task2mvp.model.hutang.getData

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

data class DataItem (

        @field:SerializedName("nohp_penghutang")
        val nohpPenghutang: String? = null,

        @field:SerializedName("id_hutang")
        val idHutang: String? = null,

        @field:SerializedName("nama_penghutang")
        val namaPenghutang: String? = null,

        @field:SerializedName("tanggal_pinjam")
        val tanggalPinjam: String? = null,

        @field:SerializedName("tanggal_kembali")
        val tanggalKembali: String? = null
)