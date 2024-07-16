package com.papaours.sessionformation.domain.exception

abstract class SessionFormationException: RuntimeException() {
    abstract override val message: String
}