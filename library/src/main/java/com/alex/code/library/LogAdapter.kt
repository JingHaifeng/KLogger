package com.alex.code.library

/**
 * Created by alex on 17-10-10.
 */

interface LogAdapter {
    fun isLoggable(priority: Int, tag: String): Boolean

    fun log(priority: Int, tag: String?, message: String?)
}

class AndroidLogAdapter : LogAdapter {

    private val formatStrategy: FormatStrategy = PrettyFormatStrategy.build { strategy = LogcatStrategy() }

    override fun isLoggable(priority: Int, tag: String): Boolean {
        return true
    }

    override fun log(priority: Int, tag: String?, message: String?) {
        formatStrategy.log(priority, tag, message)
    }
}

