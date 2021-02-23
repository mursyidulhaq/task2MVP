package com.mursyidul.task2mvp.view.register

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.mursyidul.task2mvp.R
import com.mursyidul.task2mvp.model.register.ResponseServerRegister
import com.mursyidul.task2mvp.presenter.register.RegisterInterface
import com.mursyidul.task2mvp.presenter.register.RegisterPresenter
import com.mursyidul.task2mvp.view.login.LoginActivity
import kotlinx.android.synthetic.main.activity_register.*

class RegisterActivity : AppCompatActivity(), RegisterInterface {
    private var registerPresenter :RegisterPresenter ? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)

        registerPresenter = RegisterPresenter(this)
        btnsignup.setOnClickListener {
            val nama = etnama.text.toString()
            val email = etemail.text.toString()
            val password = etpassword.text.toString()
            val pasworrd2 = etpassword2.text.toString()
            registerPresenter?.register(nama,email,password,pasworrd2)

        }

    }

    override fun succecRegister(response: ResponseServerRegister) {
        startActivity(Intent(this,LoginActivity::class.java))
    }

    override fun errorRegister(msg: String) {
        showToas(msg)
    }

    override fun empty() {
        showToas("data tidak boleh kosong")
    }

    override fun noMact() {
        showToas("password tidak cocok")
    }

    fun showToas(msg :String)
    {
        Toast.makeText(applicationContext,msg,Toast.LENGTH_SHORT).show()
    }
}