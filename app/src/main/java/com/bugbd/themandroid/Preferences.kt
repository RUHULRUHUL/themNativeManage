package com.bugbd.themandroid

import android.content.Context
import android.content.SharedPreferences

class Preferences {

    private lateinit var sharedPreferences: SharedPreferences
    private lateinit var myEdit: SharedPreferences.Editor

    fun initPreference(context: Context){
        sharedPreferences =
            context.getSharedPreferences("com.bugbd.themandroid", Context.MODE_PRIVATE)
        myEdit = sharedPreferences.edit()
    }


    fun getThem(): String? {
        return sharedPreferences.getString("saveThem", "MODE_NIGHT_FOLLOW_SYSTEM")
    }

    fun saveThem(them: String) {
        myEdit.putString("saveThem", them)
        myEdit.commit()
        myEdit.apply()
    }

}