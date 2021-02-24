package com.mursyidul.task2mvp.presenter.register

import com.mursyidul.task2mvp.model.register.ResponseServerRegister
import com.mursyidul.task2mvp.network.register.ConfigNetwork
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class RegisterPresenter (var registerView :RegisterInterface){
 fun register(nama:String,email:String,password:String,passwordcomrfirm :String)
 {



         if (password != passwordcomrfirm)
         {
             registerView.noMact()
         }else if (password.length < 5 )
         {
             registerView.errorRegister("Password minimal 6 karakter")
         }
         else {
             ConfigNetwork.getRetrofit().register(nama, email, password)
                 .enqueue(object : Callback<ResponseServerRegister> {
                     override fun onFailure(call: Call<ResponseServerRegister>, t: Throwable) {
                         registerView.errorRegister(t.localizedMessage)
                     }

                     override fun onResponse(
                         call: Call<ResponseServerRegister>,
                         response: Response<ResponseServerRegister>
                     ) {
                         if (response.isSuccessful) {
                             val responseServer = response.body()
                             val message = response.body()?.message
                             val status = response.body()?.isSuccess
                             if (status ?: true) {
                                 responseServer?.let { registerView.succecRegister(it) }
                             } else {
                                 registerView.errorRegister(message ?: "")
                             }

                         }
                     }
                 })
         }

 }
}