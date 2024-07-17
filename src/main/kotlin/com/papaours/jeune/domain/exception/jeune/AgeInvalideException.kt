package com.papaours.jeune.domain.exception.jeune

class AgeInvalideException : JeuneException() {
    override val message: String = "Tu n'es plus tout jeune..."
}
