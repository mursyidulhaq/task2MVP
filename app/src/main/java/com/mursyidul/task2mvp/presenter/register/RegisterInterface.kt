package com.mursyidul.task2mvp.presenter.register

import com.mursyidul.task2mvp.model.register.ResponseServerRegister

interface RegisterInterface {


    fun succecRegister(response :ResponseServerRegister)
    fun errorRegister(msg: String)
    fun empty()
    fun noMact()
}