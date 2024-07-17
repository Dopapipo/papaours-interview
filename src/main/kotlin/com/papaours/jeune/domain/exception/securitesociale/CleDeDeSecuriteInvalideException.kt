package com.papaours.jeune.domain.exception.securitesociale

class CleDeDeSecuriteInvalideException : NumeroDeSecuriteSocialeException() {
    override val message: String = "La clé de sécurité est invalide"
}
