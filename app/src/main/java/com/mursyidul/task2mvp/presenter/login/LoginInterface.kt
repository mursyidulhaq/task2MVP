package com.mursyidul.task2mvp.presenter.login

import com.mursyidul.task2mvp.model.login.DataItem
import com.mursyidul.task2mvp.model.login.ResponseServerLogin

interface LoginInterface {

    fun onResponseLogin(msg: String,data:List<DataItem>)
    fun isErrorLogin(msg :String)
    fun isEmpty()

}