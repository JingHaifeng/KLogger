package com.alex.code.library

import android.util.Log

/**
 * Created by alex on 17-10-10.
 */
interface LogStrategy {
    fun log(priority: Int, tag: String?, message: String?)
}

class LogcatStrategy : LogStrategy {
    override fun log(priority: Int, tag: String?, message: String?) {
        Log.println(priority, tag, message)
        Log.d("tag","final")
    }
}