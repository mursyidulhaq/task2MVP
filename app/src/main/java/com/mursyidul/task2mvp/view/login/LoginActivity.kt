package com.mursyidul.task2mvp.view.login

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.mursyidul.task2mvp.Helpert.SesionsManager
import com.mursyidul.task2mvp.R
import com.mursyidul.task2mvp.model.login.DataItem
import com.mursyidul.task2mvp.model.login.ResponseServerLogin
import com.mursyidul.task2mvp.presenter.login.LoginInterface
import com.mursyidul.task2mvp.presenter.login.LoginPresenter
import com.mursyidul.task2mvp.view.produksi.HutangActivity
import com.mursyidul.task2mvp.view.register.RegisterActivity
import kotlinx.android.synthetic.main.activity_login.*

class LoginActivity : AppCompatActivity(), LoginInterface {
    private var loginpresenter :LoginPresenter ?= null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        loginpresenter = LoginPresenter(this)
        btnLogin.setOnClickListener {

            val email = etemaillogin.text.toString()
            val password = etpasswordlogin.text.toString()

            loginpresenter?.login(email,password)
        }
        txtregister.setOnClickListener {
            startActivity(Intent(this,RegisterActivity::class.java))
        }

    }




    override fun onResponseLogin(msg: String,data: List<DataItem>) {
        var session = SesionsManager(this)
        session.name = data.get(0).nama
        session.email = data.get(0).email
        session.log = true
        startActivity(Intent(this,HutangActivity::class.java))
    }


    override fun isErrorLogin(msg: String) {
        showToas("email atau password tidak valid")
    }

    override fun isEmpty() {
        showToas("data tidak boleh kosong")
    }

    fun showToas(msg :String){
        Toast.makeText(applicationContext,msg,Toast.LENGTH_SHORT).show()
    }
}