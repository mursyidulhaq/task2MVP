package com.mursyidul.task2mvp.view.produksi

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.mursyidul.task2mvp.Helpert.SesionsManager
import com.mursyidul.task2mvp.R
import com.mursyidul.task2mvp.view.login.LoginActivity
import kotlinx.android.synthetic.main.activity_hutang.*

class HutangActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_hutang)

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
}