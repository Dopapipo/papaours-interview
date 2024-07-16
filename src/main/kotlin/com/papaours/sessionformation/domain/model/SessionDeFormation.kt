package com.papaours.sessionformation.domain.model

import com.papaours.sharedkernel.tauxcompletion.TauxCompletion
import java.time.LocalDate
import java.util.*

data class SessionDeFormation(
    val id: UUID,
    val nom: String,
    val dateDeDebut: LocalDate,
    val dateDeFin: LocalDate,
    val dateDeFinExamen: LocalDate,
    val nombrePlaces: Int,
    val volumeHoraireTotal: Float,
    val langue: String,
    val statut: String,
    val periodes: List<Periode>,
    val duree: Duree,
    val formation: Formation,
    val siteDeFormation: SiteDeFormation
) {
    private var etat: EtatSessionDeFormation = EtatSessionDeFormation()

    fun changerEtat(etat: EtatSessionDeFormation) = apply {
        this.etat = etat
    }

    fun tauxCompletion(): TauxCompletion {
        return etat.tauxCompletion(this)
    }

    fun recupererChampsInvalide(): List<EtatSessionDeFormation.ChampInvalide> {
        return etat.recupererChampsInvalides(this)
    }

    data class Periode(
        val nom: String,
        val dateDeDebut: LocalDate,
        val dateDeFin: LocalDate
    )

    data class Duree(
        val volume: Float,
        val temporalite: Temporalite,
    ) {
        enum class Temporalite(val nomTemporalite: String) {
            MINUTE("min"),
            HEURE("h"),
            JOUR("j"),
            MOIS("mois"),
            ANNEE("an");

            companion object {
                fun fromString(valeur: String): Temporalite {
                    return entries.firstOrNull { it.nomTemporalite == valeur }
                        ?: throw IllegalArgumentException("Aucune Temporalite avec la valeur: $valeur")
                }
            }
        }

        override fun toString(): String {
            return this.volume.toString() + " " + this.temporalite.nomTemporalite
        }
    }

    data class Formation(
        val identifiant: String,
        val intitule: String,
        val intituleCours: String,
        val statut: String,
        val conformite: String,
        val type: String,
        val description: String,
        val diplome: Diplome,
        val certificationProfessionnel: CertificationProfessionnel
    ) {
        data class Diplome(
            val nature: String,
            val description: String,
            val niveau: String,
            val intitule: String,
            val code: CodeDiplome,
            val typeDiplome: TypeDiplome
        ) {
            data class CodeDiplome(val value: String): Validateur(value, CodeDiplomeFormatValidateur())
            data class TypeDiplome(
                val cle: String,
                val valeur: String,
                val categorie: String
            )
        }

        data class CertificationProfessionnel(
            val code: String,
            val type: String,
            val abregeType: String,
            val volumeHoraireTotal: Float,
            val libelle: String,
            val statut: String
        )
    }

    data class SiteDeFormation(
        val siret: String,
        val nomLegal: String,
        val nomCommercial: String,
        val statut: String,
        val ville: String,
    )
}
