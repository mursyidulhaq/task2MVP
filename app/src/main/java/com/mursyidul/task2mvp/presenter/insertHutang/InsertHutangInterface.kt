package com.mursyidul.task2mvp.presenter.insertHutang

import com.mursyidul.task2mvp.model.hutang.insert.ResponseServerInsertHutang

interface InsertHutangInterface {
    fun onResponseInsert(responseServer : ResponseServerInsertHutang)
    fun isErrorInser(msg :String)
    fun isEmpty()
}