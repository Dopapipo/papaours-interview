package com.papaours.jeune.domain.model

import java.time.LocalDate
import java.util.*

data class Jeune(
    val id: UUID,
    val nom: String,
    val prenom: String,
    val email: String,
    val dateNaissance: LocalDate,
    val numeroSecuriteSociale: NumeroSecuriteSociale,
    val validateur: JeuneValidateur

) {
    init {
        this.validateur(this)
    }

    // on compare pas les ids et les validateurs (temp workaround pour l'id avant discussion)
    // TODO: talk
    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other !is Jeune) return false

        if (nom != other.nom) return false
        if (prenom != other.prenom) return false
        if (email != other.email) return false
        if (dateNaissance != other.dateNaissance) return false
        if (numeroSecuriteSociale != other.numeroSecuriteSociale) return false

        return true
    }

    override fun hashCode(): Int {
        return super.hashCode()
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

        override fun toString(): String {
            return sexe + anneeNaissance + moisNaissance + departementNaissance + insee + ordreEnregistrement + cle
        }
    }
}
