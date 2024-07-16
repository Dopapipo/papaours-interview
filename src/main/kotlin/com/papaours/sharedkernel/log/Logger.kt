package com.papaours.sharedkernel.log

import org.slf4j.Logger
import org.slf4j.LoggerFactory

class CustomLogger(clazz: Class<*>) {

    private var logger: Logger = LoggerFactory.getLogger(clazz)

    fun debug(message: String) {
        logger.debug(message)
    }

    fun info(message: String) {
        logger.info(message)
    }

    fun warn(message: String) {
        logger.warn(message)
    }

    fun error(message: String) {
        logger.error(message)
    }

    fun error(message: String, throwable: Throwable) {
        logger.error(message, throwable)
    }

    companion object {
        fun logger(clazz: Class<*>): CustomLogger {
            return CustomLogger(clazz)
        }
    }
}