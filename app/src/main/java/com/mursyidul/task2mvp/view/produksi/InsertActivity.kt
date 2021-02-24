package com.mursyidul.task2mvp.view.produksi

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.mursyidul.task2mvp.R
import com.mursyidul.task2mvp.model.hutang.insert.ResponseServerInsertHutang
import com.mursyidul.task2mvp.presenter.insertHutang.InsertHutang
import com.mursyidul.task2mvp.presenter.insertHutang.InsertHutangInterface
import kotlinx.android.synthetic.main.activity_insert.*

class InsertActivity : AppCompatActivity(),InsertHutangInterface {

    private var insertPresenter :InsertHutang ?=null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_insert)

        insertPresenter= InsertHutang(this)

        btnsimpan.setOnClickListener {
            val nama = txtnamahutang.text.toString()
            val nohp=txtnohphutang.text.toString()
            val tgl_pinjam =txtpinjamhutang.text.toString()
            val tgl_kembali =txtkembalihutang.text.toString()

            insertPresenter?.insert(nama,nohp,tgl_pinjam,tgl_kembali)
        }



    }

    override fun onResponseInsert(responseServer: ResponseServerInsertHutang) {
        showToas("berhasil")
        finish()
    }

    override fun isErrorInser(msg: String) {
       showToas("data gagal disimpan")
    }

    override fun isEmpty() {
        showToas("data kosong")
    }
    fun showToas(msg :String)
    {
        Toast.makeText(applicationContext,msg, Toast.LENGTH_SHORT).show()
    }
}