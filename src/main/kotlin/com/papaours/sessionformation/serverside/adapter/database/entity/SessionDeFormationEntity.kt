package com.papaours.sessionformation.serverside.adapter.database.entity

import java.util.UUID


data class SessionDeFormationEntity(
    val id: UUID? = null,
    val informations: SessionDeFormationInformations? = null
)

data class SessionDeFormationInformations(
    val nom: String,
    val dateDeDebut: String,
    val dateDeFin: String,
    val dateDeFinExamen: String,
    val nombrePlaces: Int,
    val volumeHoraireTotal: Float,
    val langue: String,
    val statut: String,
    val periodes: List<Periode>,
    val duree: Duree,
    val formation: Formation,
    val siteDeFormation: SiteDeFormation
) {
    data class Periode(
        val nom: String,
        val dateDeDebut: String,
        val dateDeFin: String
    )

    data class Duree(
        val volume: Float,
        val temporalite: String,
    )

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
            val code: String,
            val typeDiplome: TypeDiplome
        ) {
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