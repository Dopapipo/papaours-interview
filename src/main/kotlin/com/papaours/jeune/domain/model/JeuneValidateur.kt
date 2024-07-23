package com.papaours.jeune.domain.model

import com.papaours.jeune.domain.exception.jeune.AgeInvalideException
import com.papaours.jeune.domain.exception.jeune.FormatInvalideException
import java.time.LocalDate

class JeuneValidateur {
    operator fun invoke(jeune: Jeune) {
        if (!this.champsRemplis(jeune)) {
            throw FormatInvalideException("Tous les champs sont obligatoires")
        }
        if (!this.entreQuinzeEtTrenteAns(jeune)) {
            throw AgeInvalideException()
        }
        if(!this.emailValidation(jeune)){
            throw FormatInvalideException("Email invalide")
        }
    }

    private fun champsRemplis(jeune: Jeune): Boolean {
        return jeune.nom.isNotEmpty() && jeune.prenom.isNotEmpty() && jeune.email.isNotEmpty() && jeune.numeroSecuriteSociale.toString().isNotEmpty()
    }

    private fun entreQuinzeEtTrenteAns(jeune: Jeune): Boolean {
        val dateNaissance = jeune.dateNaissance
        val dateActuelle = LocalDate.now()
        val age = dateActuelle.year - dateNaissance.year
        return age in 15..30
    }
    private fun emailValidation(jeune: Jeune): Boolean {
        return jeune.email.matches(Regex("^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}\$"))
    }
}
