package com.mursyidul.task2mvp.view.produksi

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import com.mursyidul.task2mvp.Helpert.SesionsManager
import com.mursyidul.task2mvp.R
import com.mursyidul.task2mvp.adapter.HutangAdapter
import com.mursyidul.task2mvp.model.hutang.getData.DataItem
import com.mursyidul.task2mvp.model.hutang.getData.ResponseSeverGetDataHutang
import com.mursyidul.task2mvp.model.hutang.insert.ResponseServerInsertHutang
import com.mursyidul.task2mvp.presenter.hutang.HutangInterface
import com.mursyidul.task2mvp.presenter.hutang.HutangPresenter
import com.mursyidul.task2mvp.view.login.LoginActivity
import kotlinx.android.synthetic.main.activity_hutang.*

class HutangActivity : AppCompatActivity(),HutangInterface{
    private var hutangpresenter :HutangPresenter ?= null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_hutang)

        hutangpresenter = HutangPresenter(this)

        hutangpresenter?.getData()


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
//

    override fun succecRegister(response: ResponseSeverGetDataHutang) {
            val adapterHutang = HutangAdapter(response.data!!,object :HutangAdapter.onClickListener{
                    override fun detail(item: DataItem?) {
                        val intent = Intent(applicationContext, UpdateActivity::class.java)
                        intent.putExtra("id",item?.idHutang)
                        intent.putExtra("nama",item?.namaPenghutang)
                        intent.putExtra("nohp",item?.namaPenghutang)
                        intent.putExtra("tgl_pinjam",item?.tanggalPinjam)
                        intent.putExtra("tgl_kembali",item?.tanggalKembali)
                        startActivity(intent)
                    }

                    override fun hapus(item: DataItem?) {

                        AlertDialog.Builder(this@HutangActivity).apply {
                            setTitle("Hapus Data")
                            setMessage("yakin mau menghapus data ?")
                            setPositiveButton("hapus") { dialog, which ->
                                hutangpresenter?.deleteHutang(item?.idHutang!!)
                                dialog.dismiss()
                                setNegativeButton("Batal") { dialog, which ->
                                    dialog.dismiss()

                                }
                            }.show()

                        }
                    }
                })

             rvhutang.adapter = adapterHutang

    }

    override fun delete(response: ResponseServerInsertHutang) {
       showToas("data berhasil di delete")
        hutangpresenter?.getData()
    }

    override fun errorRegister(msg: String) {
        showToas("response failed")
    }


    fun showToas(msg :String){
        Toast.makeText(applicationContext,msg, Toast.LENGTH_SHORT).show()
    }

    override fun onResume() {
        super.onResume()
        hutangpresenter?.getData()

    }
}