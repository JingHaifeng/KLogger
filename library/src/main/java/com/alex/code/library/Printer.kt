package com.alex.code.library

/**
 * Created by alex on 17-10-10.
 */

interface Printer {

    fun log(priority: Int, tag: String?, message: String?, throwable: Throwable?)

    fun t(tag: String)

    fun d(message: String?, vararg args: Any)

    fun e(message: String, vararg args: Any)

    fun i(message: String, vararg args: Any)

    fun v(message: String, vararg args: Any)

    fun w(message: String, vararg args: Any)

    fun wtf(message: String, vararg args: Any)

    fun addLogAdapter(logAdapter: LogAdapter)

    fun clearLogAdapters()
}

class LoggerPrinter : Printer {

    private val localTag: ThreadLocal<String> = ThreadLocal()

    private var tag: String?
        set(value) {
            localTag.set(value)
        }
        get() {
            return localTag.get()
        }

    private val logAdapters: MutableList<LogAdapter> = mutableListOf()

    override fun clearLogAdapters() {
        logAdapters.clear()
    }

    override fun addLogAdapter(logAdapter: LogAdapter) {
        logAdapters.add(logAdapter)
    }

    override fun t(tag: String) {
        this.tag = tag
    }

    override fun d(message: String?, vararg args: Any) {
        log(LogState.DEBUG.priority, null, message, args)
    }

    override fun e(message: String, vararg args: Any) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun i(message: String, vararg args: Any) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun v(message: String, vararg args: Any) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun w(message: String, vararg args: Any) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun wtf(message: String, vararg args: Any) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }


    override fun log(priority: Int, tag: String?, message: String?, throwable: Throwable?) {
        logAdapters.forEach({
            it.log(priority, tag, message)
        })
    }

    private @Synchronized fun log(priority: Int, throwable: Throwable?, message: String?, vararg args: Any) {
        log(priority, tag, createMessage(message, args), throwable)
    }

    private fun createMessage(message: String?, vararg args: Any?): String? {
        if (args.isEmpty()) {
            return message
        } else {
            return String.format(message ?: "", args)
        }
    }
}