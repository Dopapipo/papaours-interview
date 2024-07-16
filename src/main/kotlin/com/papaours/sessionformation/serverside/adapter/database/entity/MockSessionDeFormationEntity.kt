package com.papaours.sessionformation.serverside.adapter.database.entity

import com.papaours.sessionformation.domain.model.SessionDeFormation
import java.util.UUID

class MockSessionDeFormationEntity {
    companion object {
        val mockSessionDeFormationEntity = SessionDeFormationEntity(
            id = UUID.fromString("a84fe4a6-fba9-4005-8ce1-a255b01491cc"),
            informations = SessionDeFormationInformations(
                nom = "annee1",
                volumeHoraireTotal = 2f,
                dateDeDebut = "2024-02-20",
                dateDeFin = "2024-02-23",
                dateDeFinExamen = "2024-02-23",
                langue = "",
                statut = "",
                nombrePlaces = 100,
                periodes = listOf(
                    SessionDeFormationInformations.Periode(
                        nom = "",
                        dateDeDebut = "2024-02-20",
                        dateDeFin = "2024-02-23"
                    )
                ),
                duree = SessionDeFormationInformations.Duree(
                    volume = 100f,
                    temporalite = SessionDeFormation.Duree.Temporalite.MINUTE.nomTemporalite
                ),
                formation = SessionDeFormationInformations.Formation(
                    intitule = "BEP chaudronnerie",
                    identifiant = "",
                    intituleCours = "",
                    statut = "",
                    conformite = "",
                    type = "",
                    description = "",
                    diplome = SessionDeFormationInformations.Formation.Diplome(
                        nature = "",
                        description = "Faire des chaudron",
                        niveau = "",
                        intitule = "BEP",
                        code = "12345678",
                        typeDiplome = SessionDeFormationInformations.Formation.Diplome.TypeDiplome(
                            cle = "",
                            valeur = "",
                            categorie = ""
                        )
                    ),
                    certificationProfessionnel = SessionDeFormationInformations.Formation.CertificationProfessionnel(
                        code = "RNCP1233",
                        type = "",
                        abregeType = "",
                        volumeHoraireTotal = 30.0f,
                        libelle = "",
                        statut = ""
                    )
                ),
                siteDeFormation = SessionDeFormationInformations.SiteDeFormation(
                    siret = "12345678912345",
                    nomLegal = "Le batiment",
                    nomCommercial = "L'opera",
                    statut = "",
                    ville = "Lille"
                )
            )
        )
    }
}