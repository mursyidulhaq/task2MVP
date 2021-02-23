package com.mursyidul.task2mvp.view.splassSreen

import android.content.Intent
import android.media.session.MediaSessionManager
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.se.omapi.Session
import com.mursyidul.task2mvp.Helpert.SesionsManager
import com.mursyidul.task2mvp.R
import com.mursyidul.task2mvp.view.login.LoginActivity
import com.mursyidul.task2mvp.view.produksi.HutangActivity

class SplassScreenActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splass_screen)

        val session = SesionsManager(this)
        Handler().postDelayed({
            if (session.log ?:true)
            {
                startActivity(Intent(this,HutangActivity::class.java))
            }else
            {
                startActivity(Intent(this,LoginActivity::class.java))
            }
            finish()

        },2000)
    }
}