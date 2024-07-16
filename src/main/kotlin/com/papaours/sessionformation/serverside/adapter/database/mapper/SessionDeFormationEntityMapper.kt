package com.papaours.sessionformation.serverside.adapter.database.mapper

import com.papaours.sessionformation.domain.model.SessionDeFormation
import com.papaours.sessionformation.serverside.adapter.database.entity.SessionDeFormationEntity
import com.papaours.sessionformation.serverside.adapter.database.entity.SessionDeFormationInformations

object SessionDeFormationEntityMapper {
    fun SessionDeFormation.toSessionDeFormationEntity(): SessionDeFormationEntity {
        return SessionDeFormationEntity(
            id = this.id,
            informations = SessionDeFormationInformations(
                nom = this.nom,
                dateDeDebut = this.dateDeDebut.toString(),
                dateDeFin = this.dateDeFin.toString(),
                dateDeFinExamen = this.dateDeFinExamen.toString(),
                nombrePlaces = this.nombrePlaces,
                volumeHoraireTotal = this.volumeHoraireTotal,
                langue = this.langue,
                statut = this.statut,
                periodes = this.periodes.map {
                    SessionDeFormationInformations.Periode(
                        nom = it.nom,
                        dateDeDebut = it.dateDeDebut.toString(),
                        dateDeFin = it.dateDeFin.toString()
                    )
                },
                duree = SessionDeFormationInformations.Duree(
                    volume = this.duree.volume,
                    temporalite = this.duree.temporalite.nomTemporalite
                ),
                formation = SessionDeFormationInformations.Formation(
                    identifiant = this.formation.identifiant,
                    intitule = this.formation.intitule,
                    intituleCours = this.formation.intituleCours,
                    statut = this.formation.statut,
                    conformite = this.formation.conformite,
                    type = this.formation.type,
                    description = this.formation.description,
                    diplome = SessionDeFormationInformations.Formation.Diplome(
                        nature = this.formation.diplome.nature,
                        description = this.formation.diplome.description,
                        niveau = this.formation.diplome.niveau,
                        intitule = this.formation.diplome.intitule,
                        code = this.formation.diplome.code.value,
                        typeDiplome = SessionDeFormationInformations.Formation.Diplome.TypeDiplome(
                            cle = this.formation.diplome.typeDiplome.cle,
                            valeur = this.formation.diplome.typeDiplome.valeur,
                            categorie = this.formation.diplome.typeDiplome.categorie
                        )
                    ),
                    certificationProfessionnel = SessionDeFormationInformations.Formation.CertificationProfessionnel(
                        code = this.formation.certificationProfessionnel.code,
                        type = this.formation.certificationProfessionnel.type,
                        abregeType = this.formation.certificationProfessionnel.abregeType,
                        volumeHoraireTotal = this.formation.certificationProfessionnel.volumeHoraireTotal,
                        libelle = this.formation.certificationProfessionnel.libelle,
                        statut = this.formation.certificationProfessionnel.statut
                    )
                ),
                siteDeFormation = SessionDeFormationInformations.SiteDeFormation(
                    siret = this.siteDeFormation.siret,
                    nomLegal = this.siteDeFormation.nomLegal,
                    nomCommercial = this.siteDeFormation.nomCommercial,
                    statut = this.siteDeFormation.statut,
                    ville = this.siteDeFormation.ville
                )
            )
        )
    }
}