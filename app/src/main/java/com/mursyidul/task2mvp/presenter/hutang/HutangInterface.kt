package com.mursyidul.task2mvp.presenter.hutang

import com.mursyidul.task2mvp.model.hutang.getData.ResponseSeverGetDataHutang
import com.mursyidul.task2mvp.model.hutang.insert.ResponseServerInsertHutang

interface HutangInterface {
    fun succecRegister(response: ResponseSeverGetDataHutang)
    fun delete(response: ResponseServerInsertHutang)
    fun errorRegister(msg: String)

}