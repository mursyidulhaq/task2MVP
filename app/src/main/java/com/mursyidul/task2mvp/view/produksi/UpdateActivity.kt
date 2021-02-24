package com.mursyidul.task2mvp.view.produksi

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.mursyidul.task2mvp.R
import com.mursyidul.task2mvp.model.hutang.getData.ResponseSeverGetDataHutang
import com.mursyidul.task2mvp.model.hutang.insert.ResponseServerInsertHutang
import com.mursyidul.task2mvp.presenter.insertHutang.InsertHutang
import com.mursyidul.task2mvp.presenter.insertHutang.InsertHutangInterface
import kotlinx.android.synthetic.main.activity_update.*

class UpdateActivity : AppCompatActivity(),InsertHutangInterface {
    private  var updatePresenter :InsertHutang ?=null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_update)
        updatePresenter = InsertHutang(this)
        val id = intent.getStringExtra("id")
         val n = intent.getStringExtra("nama")
        val no=intent.getStringExtra("nohp")
        val tglp = intent.getStringExtra("tgl_pinjam")
        val tglk = intent.getStringExtra("tgl_kembali")

        txtnamauhutang.setText(n.toString())
        txtnohpuhutang.setText(no.toString())
        txtpinjamuhutang.setText(tglp.toString())
        txtkembaliuhutang.setText(tglk.toString())

        btnupdate.setOnClickListener {
            val nama = txtnamauhutang.text.toString()
            val nohp = txtnohpuhutang.text.toString()
            val tgl_pinjam = txtpinjamuhutang.text.toString()
            val tgl_kembali = txtkembaliuhutang.text.toString()
            updatePresenter?.update(id.toString(),nama,nohp,tgl_pinjam,tgl_kembali)
        }
    }

    override fun onResponseInsert(responseServer: ResponseServerInsertHutang) {
        showToas("data berhasil di update")
    }

    override fun isErrorInser(msg: String) {
        showToas("updatedata gagal di ")
        finish()
    }

    override fun isEmpty() {
       showToas("data kosong")
    }
    fun showToas(msg :String)
    {
        Toast.makeText(applicationContext,msg, Toast.LENGTH_SHORT).show()
    }
}