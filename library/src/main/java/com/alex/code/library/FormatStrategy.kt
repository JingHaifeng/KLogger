package com.alex.code.library

/**
 * Created by alex on 17-10-10.
 */

interface FormatStrategy {
    fun log(priority: Int, tag: String?, message: String?)
}

class PrettyFormatStrategy private constructor(val logStrategy: LogStrategy) : FormatStrategy {

    private constructor(builder: Builder) : this(builder.strategy)

    override fun log(priority: Int, tag: String?, message: String?) {
        logStrategy.log(priority, tag, message)
    }

    fun logTopBorder(priority: Int, tag: String) {

    }

    companion object {
        /**
         * Drawing toolbox
         */
        private val TOP_LEFT_CORNER = '┌'
        private val BOTTOM_LEFT_CORNER = '└'
        private val MIDDLE_CORNER = '├'
        private val HORIZONTAL_LINE = '│'
        private val DOUBLE_DIVIDER = "────────────────────────────────────────────────────────"
        private val SINGLE_DIVIDER = "┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄"
        private val TOP_BORDER = TOP_LEFT_CORNER + DOUBLE_DIVIDER + DOUBLE_DIVIDER
        private val BOTTOM_BORDER = BOTTOM_LEFT_CORNER + DOUBLE_DIVIDER + DOUBLE_DIVIDER
        private val MIDDLE_BORDER = MIDDLE_CORNER + SINGLE_DIVIDER + SINGLE_DIVIDER

        fun build(init: Builder.() -> Unit) = Builder(init).build()
    }

    class Builder private constructor() {
        constructor(init: Builder.() -> Unit) : this() {
            init()
        }

        // property
        var strategy: LogStrategy = LogcatStrategy()

        // DSL
        fun logStrategy(init: Builder.() -> LogStrategy) = apply { strategy = init() }

        // create
        fun build() = PrettyFormatStrategy(this)
    }
}