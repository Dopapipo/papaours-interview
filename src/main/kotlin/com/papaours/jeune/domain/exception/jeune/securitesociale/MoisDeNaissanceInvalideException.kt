package com.papaours.jeune.domain.exception.jeune.securitesociale

class MoisDeNaissanceInvalideException() : NumeroDeSecuriteSocialeException() {
    override val message: String = "Le mois de naissance doit être compris entre 01 et 12"
}
