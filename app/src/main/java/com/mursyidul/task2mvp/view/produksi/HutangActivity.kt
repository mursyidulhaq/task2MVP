package com.mursyidul.task2mvp.view.produksi

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.mursyidul.task2mvp.Helpert.SesionsManager
import com.mursyidul.task2mvp.R
import com.mursyidul.task2mvp.adapter.HutangAdapter
import com.mursyidul.task2mvp.model.hutang.getData.DataItem
import com.mursyidul.task2mvp.model.hutang.getData.ResponseSeverGetDataHutang
import com.mursyidul.task2mvp.presenter.hutang.HutangInterface
import com.mursyidul.task2mvp.presenter.hutang.HutangPresenter
import com.mursyidul.task2mvp.presenter.login.LoginPresenter
import com.mursyidul.task2mvp.view.login.LoginActivity
import kotlinx.android.synthetic.main.activity_hutang.*

class HutangActivity : AppCompatActivity(),HutangInterface{
    private var hutangpresenter :HutangPresenter ?= null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_hutang)

        hutangpresenter = HutangPresenter(this)

        fbhutang.setOnClickListener {
            startActivity(Intent(this,InsertActivity::class.java))
        }

        val session = SesionsManager(this)
        logout.setOnClickListener {
            session.logout()
            val intent = Intent(this,LoginActivity::class.java)
            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
            intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK)
            intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP)
            startActivity(intent)

        }
    }

    override fun succecRegister(response: ResponseSeverGetDataHutang) {
            val adapter = response.data?.let {
                HutangAdapter(it, object:HutangAdapter.onClickListener{
                    override fun detail(item: DataItem?) {

                        val intent = Intent(applicationContext,
                            InsertActivity::class.java)
                        intent.putExtra("nama",item?.namaPenghutang)
                        intent.putExtra("nohp",item?.namaPenghutang)
                        intent.putExtra("tgl_pinjam",item?.tanggalPinjam)
                        intent.putExtra("tgl_kembali",item?.tanggalKembali)
                        startActivity(intent)



                    }

                    override fun hapus(item: DataItem?) {
                        TODO("Not yet implemented")
                    }

                })
            }
    }

    override fun errorRegister(msg: String) {
        showToas("response failed")
    }

    override fun empty() {
        showToas("data kosong")
    }
    fun showToas(msg :String){
        Toast.makeText(applicationContext,msg, Toast.LENGTH_SHORT).show()
    }
}