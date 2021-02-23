package com.mursyidul.task2mvp.presenter.hutang

import com.mursyidul.task2mvp.model.hutang.getData.ResponseSeverGetDataHutang
import com.mursyidul.task2mvp.model.register.ResponseServerRegister

interface HutangInterface {
    fun succecRegister(response : ResponseSeverGetDataHutang)
    fun errorRegister(msg: String)
    fun empty()
}