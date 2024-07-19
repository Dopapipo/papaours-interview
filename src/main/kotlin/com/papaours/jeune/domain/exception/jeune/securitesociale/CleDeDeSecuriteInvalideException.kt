package com.papaours.jeune.domain.exception.jeune.securitesociale

class CleDeDeSecuriteInvalideException : NumeroDeSecuriteSocialeException() {
    override val message: String = "La clé de sécurité est invalide"
}
