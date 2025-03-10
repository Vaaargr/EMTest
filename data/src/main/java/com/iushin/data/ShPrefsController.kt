package com.iushin.data

import android.content.SharedPreferences

class ShPrefsController(private val prefs: SharedPreferences) {

    fun saveCount(count: Int){
        prefs.edit().putInt("COUNT", count).apply()
    }
}