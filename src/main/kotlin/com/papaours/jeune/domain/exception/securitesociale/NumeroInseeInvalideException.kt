package com.papaours.jeune.domain.exception.securitesociale

class NumeroInseeInvalideException () : NumeroDeSecuriteSocialeException() {
    override val message: String = "Le numéro INSEE doit être compris entre 001 et 999"
}
