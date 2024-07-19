package com.papaours.jeune.domain.exception.jeune.securitesociale

class AnneeDeNaissanceInvalideException() : NumeroDeSecuriteSocialeException() {
    override val message: String =
        "L'année de naissance doit comprendre les 2 derniers chiffres de l'année de naissance"
}
