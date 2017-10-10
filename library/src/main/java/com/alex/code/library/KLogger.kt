package com.alex.code.library


/**
 * Created by alex on 17-10-10.
 */

object KLogger {

    var printer: Printer = LoggerPrinter()

    fun clearLogAdapters() {
        printer.clearLogAdapters()
    }

    fun addLogAdapter(logAdapter: LogAdapter) {
        printer.addLogAdapter(logAdapter)
    }

    fun t(tag: String) {
        printer.t(tag)
    }

    fun log(priority: Int, tag: String, message: String, throwable: Throwable) {
        printer.log(priority, tag, message, throwable)
    }

    fun d(message: String, vararg anys: Any) {
        printer.d(message, anys)
    }

}