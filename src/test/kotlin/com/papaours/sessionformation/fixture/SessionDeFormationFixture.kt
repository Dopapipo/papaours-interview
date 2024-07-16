package com.papaours.sessionformation.fixture

import com.papaours.gestion.sessionformation.userside.restResources.RecupererSessionDeFormationRestResource
import com.papaours.sessionformation.domain.model.SessionDeFormation
import com.papaours.sessionformation.serverside.adapter.database.entity.SessionDeFormationEntity
import com.papaours.sessionformation.serverside.adapter.database.entity.SessionDeFormationInformations
import java.time.LocalDate
import java.util.*

class SessionDeFormationFixture {
    companion object {
        val mockSessionDeFormation = SessionDeFormation(
            id = UUID.fromString("a84fe4a6-fba9-4005-8ce1-a255b01491cc"),
            nom = "annee1",
            volumeHoraireTotal = 2f,
            dateDeDebut = LocalDate.of(2024, 2, 20),
            dateDeFin = LocalDate.of(2024, 2, 23),
            dateDeFinExamen = LocalDate.of(2024, 2, 23),
            langue = "",
            statut = "",
            nombrePlaces = 100,
            periodes = listOf(
                SessionDeFormation.Periode(
                    nom = "",
                    dateDeDebut = LocalDate.of(2024, 2, 20),
                    dateDeFin = LocalDate.of(2024, 2, 23)
                )
            ),
            duree = SessionDeFormation.Duree(
                volume = 100f,
                temporalite = SessionDeFormation.Duree.Temporalite.MINUTE
            ),
            formation = SessionDeFormation.Formation(
                intitule = "BEP chaudronnerie",
                identifiant = "",
                intituleCours = "",
                statut = "",
                conformite = "",
                type = "",
                description = "",
                diplome = SessionDeFormation.Formation.Diplome(
                    nature = "",
                    description = "Faire des chaudron",
                    niveau = "",
                    intitule = "BEP",
                    code = SessionDeFormation.Formation.Diplome.CodeDiplome("12345678"),
                    typeDiplome = SessionDeFormation.Formation.Diplome.TypeDiplome(
                        cle = "",
                        valeur = "",
                        categorie = "",
                    )
                ),
                certificationProfessionnel = SessionDeFormation.Formation.CertificationProfessionnel(
                    code = "RNCP1233",
                    type = "",
                    abregeType = "",
                    volumeHoraireTotal = 30.0f,
                    libelle = "",
                    statut = ""
                )
            ),
            siteDeFormation = SessionDeFormation.SiteDeFormation(
                siret = "12345678912345",
                nomLegal = "Le batiment",
                nomCommercial = "L'opera",
                statut = "",
                ville = "Lille"
            )
        )

        val mockSessionDeFormation2 = SessionDeFormation(
            id = UUID.fromString("d22be1a8-e931-4679-91b2-4e451e7e89e5"),
            nom = "annee2",
            volumeHoraireTotal = 1f,
            dateDeDebut = LocalDate.of(2024, 2, 22),
            dateDeFin = LocalDate.of(2024, 2, 25),
            dateDeFinExamen = LocalDate.of(2024, 2, 25),
            langue = "",
            statut = "",
            nombrePlaces = 100,
            periodes = listOf(
                SessionDeFormation.Periode(
                    nom = "",
                    dateDeDebut = LocalDate.of(2024, 2, 22),
                    dateDeFin = LocalDate.of(2024, 2, 25)
                )
            ),
            duree = SessionDeFormation.Duree(
                volume = 1f,
                temporalite = SessionDeFormation.Duree.Temporalite.MINUTE
            ),
            formation = SessionDeFormation.Formation(
                intitule = "DUT cordonnier",
                identifiant = "",
                intituleCours = "",
                statut = "",
                conformite = "",
                type = "",
                description = "",
                diplome = SessionDeFormation.Formation.Diplome(
                    intitule = "DUT",
                    code = SessionDeFormation.Formation.Diplome.CodeDiplome("67412312"),
                    nature = "",
                    description = "Faire des chaussures",
                    niveau = "",
                    typeDiplome = SessionDeFormation.Formation.Diplome.TypeDiplome(
                        cle = "",
                        valeur = "",
                        categorie = "",
                    )
                ),
                certificationProfessionnel = SessionDeFormation.Formation.CertificationProfessionnel(
                    code = "RNCP5678",
                    type = "",
                    abregeType = "",
                    volumeHoraireTotal = 23.0f,
                    libelle = "",
                    statut = ""
                )
            ),
            siteDeFormation = SessionDeFormation.SiteDeFormation(
                siret = "11111111154321",
                nomLegal = "Le bar",
                nomCommercial = "Lippopette",
                statut = "",
                ville = "Paris"
            )
        )

        val mockSessionDeFormationEntitee = SessionDeFormationEntity(
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
                            categorie = "",
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
            ),

            )

        val mockSessionDeFormationEntitee2 = SessionDeFormationEntity(
            id = UUID.fromString("d22be1a8-e931-4679-91b2-4e451e7e89e5"),
            informations = SessionDeFormationInformations(

                nom = "annee2",
                volumeHoraireTotal = 1f,
                dateDeDebut = "2024-02-22",
                dateDeFin = "2024-02-25",
                dateDeFinExamen = "2024-02-25",
                langue = "",
                statut = "",
                nombrePlaces = 100,
                periodes = listOf(
                    SessionDeFormationInformations.Periode(
                        nom = "",
                        dateDeDebut = "2024-02-22",
                        dateDeFin = "2024-02-25"
                    )
                ),
                duree = SessionDeFormationInformations.Duree(
                    volume = 1f,
                    temporalite = SessionDeFormation.Duree.Temporalite.MINUTE.nomTemporalite
                ),
                formation = SessionDeFormationInformations.Formation(
                    intitule = "DUT cordonnier",
                    identifiant = "",
                    intituleCours = "",
                    statut = "",
                    conformite = "",
                    type = "",
                    description = "",
                    diplome = SessionDeFormationInformations.Formation.Diplome(
                        intitule = "DUT",
                        code = "67412312",
                        nature = "",
                        description = "Faire des chaussures",
                        niveau = "",
                        typeDiplome = SessionDeFormationInformations.Formation.Diplome.TypeDiplome(
                            cle = "",
                            valeur = "",
                            categorie = "",
                        )
                    ),
                    certificationProfessionnel = SessionDeFormationInformations.Formation.CertificationProfessionnel(
                        code = "RNCP5678",
                        type = "",
                        abregeType = "",
                        volumeHoraireTotal = 23.0f,
                        libelle = "",
                        statut = ""
                    )
                ),
                siteDeFormation = SessionDeFormationInformations.SiteDeFormation(
                    siret = "11111111154321",
                    nomLegal = "Le bar",
                    nomCommercial = "Lippopette",
                    statut = "",
                    ville = "Paris"
                )
            ),
        )

        val mockRecupererSessionDeFormationRestRessource = RecupererSessionDeFormationRestResource(
            id = UUID.fromString("a84fe4a6-fba9-4005-8ce1-a255b01491cc"),
            nom = "annee1",
            intituleFormation = "BEP chaudronnerie",
            codeRNCP = "RNCP1233",
            nomDiplome = "BEP",
            codeDiplome = "12345678",
            nomSiteFormation = "Le batiment",
            dateDebut = "2024-02-20",
            duree = "100.0 min",
            dateFin = "2024-02-23",
            tauxCompletion = 100
        )

        val mockRecupererSessionDeFormationRestRessource2 = RecupererSessionDeFormationRestResource(
            id = UUID.fromString("d22be1a8-e931-4679-91b2-4e451e7e89e5"),
            nom = "annee2",
            intituleFormation = "DUT cordonnier",
            codeRNCP = "RNCP5678",
            nomDiplome = "DUT",
            codeDiplome = "67412312",
            nomSiteFormation = "Le bar",
            dateDebut = "2024-02-22",
            duree = "1.0 min",
            dateFin = "2024-02-25",
            tauxCompletion = 100
        )
    }
}
