package com.alex.code.library

/**
 * Created by alex on 17-10-10.
 */
enum class LogState(val priority: Int) {
    VERBOSE(2),
    DEBUG(3),
    INFO(4),
    WARN(5),
    ERROR(6),
    ASSERT(7)
}
