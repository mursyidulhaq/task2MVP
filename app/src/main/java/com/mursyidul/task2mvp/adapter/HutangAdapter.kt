package com.mursyidul.task2mvp.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.mursyidul.task2mvp.R
import com.mursyidul.task2mvp.model.hutang.getData.DataItem
import kotlinx.android.synthetic.main.list_hutang.view.*

class HutangAdapter(val data : List<DataItem>,val itemClick: onClickListener):RecyclerView.Adapter<HutangAdapter.HutangHolder>() {
    class HutangHolder(val view :View):RecyclerView.ViewHolder(view){

        val nama =view.txtnamahutang
        val nohp = view.txtnohphutang
        val tgl_pinjam = view.txtpinjamhutang
        val tgl_kebali = view.txtkembalihutang
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HutangHolder {
        val viev = LayoutInflater.from(parent.context).inflate(R.layout.list_hutang,parent,false)
        return HutangHolder(viev)
    }

    override fun getItemCount(): Int {
        return data.size
    }

    override fun onBindViewHolder(holder: HutangHolder, position: Int) {
        val item  = data?.get(position)
        holder.nama.text = item.namaPenghutang
        holder.nohp.text = item?.nohpPenghutang
        holder.tgl_pinjam.text = item?.tanggalPinjam
        holder.tgl_kebali.text = item?.tanggalKembali

        holder.view.setOnClickListener {
            itemClick.detail(item)
        }

//        holder.btnhapus.setOnClickListener {
//            itemClick.hapus(item)
//        }
    }

    interface onClickListener{
        fun detail(item: DataItem?)
        fun hapus(item: DataItem?)


    }
}