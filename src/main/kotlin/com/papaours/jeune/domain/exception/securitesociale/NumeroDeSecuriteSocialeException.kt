package com.papaours.jeune.domain.exception.securitesociale

abstract class NumeroDeSecuriteSocialeException:RuntimeException() {
    abstract override val message: String
}
