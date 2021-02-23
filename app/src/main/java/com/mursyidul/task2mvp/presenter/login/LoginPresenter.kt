package com.mursyidul.task2mvp.presenter.login

import com.mursyidul.task2mvp.model.login.DataItem
import com.mursyidul.task2mvp.model.login.ResponseServerLogin
import com.mursyidul.task2mvp.network.login.ConfigNetworkLogin
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class LoginPresenter(var loginView :LoginInterface) {
    fun login(email:String,password:String)
    {
        if (email.isNotEmpty() && password.isNotEmpty()){

            ConfigNetworkLogin.getRetrofit().login(email,password)
                    .enqueue(object :Callback<ResponseServerLogin>{
                        override fun onFailure(call: Call<ResponseServerLogin>, t: Throwable) {
                            loginView.isErrorLogin(t.localizedMessage)
                        }

                        override fun onResponse(call: Call<ResponseServerLogin>, response: Response<ResponseServerLogin>) {
                            if (response.isSuccessful)
                            {
                                val responseServer = response.body()
                                val message = response.body()?.message
                                val status = response.body()?.isSuccess
                                if (status ?: true) {
                                    responseServer?.data
                                } else {
                                    loginView.isErrorLogin(message ?: "")
                                }
                            }
                        }
                    })


        }else
        {
            loginView.isEmpty()
        }
    }
}