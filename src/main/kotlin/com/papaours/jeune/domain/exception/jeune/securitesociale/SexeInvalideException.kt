package com.papaours.jeune.domain.exception.jeune.securitesociale

class SexeInvalideException() : NumeroDeSecuriteSocialeException() {
    override val message: String = "Le sexe doit être egal à '1' ou '2'"
}
