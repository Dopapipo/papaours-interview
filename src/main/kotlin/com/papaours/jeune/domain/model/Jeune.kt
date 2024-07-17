package com.papaours.jeune.domain.model

import jakarta.validation.constraints.Email
import java.time.LocalDate
import java.util.*

data class Jeune(
    val id: UUID,
    val nom: String,
    val prenom: String,
    val email: Email,
    val dateNaissance: LocalDate,
    val numeroSecuriteSociale: NumeroSecuriteSociale,
    val validateur: JeuneValidateur

) {
    init {
        this.validateur(this)
    }

    data class NumeroSecuriteSociale(
        val sexe: String,
        val anneeNaissance: String,
        val moisNaissance: String,
        val departementNaissance: String,
        val insee: String,
        val ordreEnregistrement: String,
        val cle: String,
        val validateur: NSSValidateur
    ) {
        init {
            this.validateur(this)
        }
    }
}
