package com.mursyidul.task2mvp.Helpert

import android.content.Context
import android.content.SharedPreferences

class SesionsManager(var c: Context) {
    var pref  : SharedPreferences? = null
    var editor :SharedPreferences.Editor? = null
    var PREF_NAME= "LOGINREGISTRASI"

    var ISLOGIN = "isLogin"
    var NAME = "name"
    var EMAIL = "email"
    init {
        pref =c.getSharedPreferences(PREF_NAME,0)
        editor = pref?.edit()
    }

    var log  :Boolean?
    get() = pref?.getBoolean(ISLOGIN,false)
    set(value) {
        editor?.putBoolean(ISLOGIN, true)
    }
        var name :String?
        get() = pref?.getString(NAME,"")
        set(nama) {
        editor?.putString(NAME,nama)
            editor?.commit()
        }
    var email :String?
        get() = pref?.getString(EMAIL,"")
        set(email) {
        editor?.putString(EMAIL,email)
            editor?.commit()

    }


fun logout(){
    editor?.clear()
    editor?.commit()
}

}