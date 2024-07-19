package com.papaours.jeune.domain.exception.jeune.securitesociale

abstract class NumeroDeSecuriteSocialeException : RuntimeException() {
    abstract override val message: String
}
