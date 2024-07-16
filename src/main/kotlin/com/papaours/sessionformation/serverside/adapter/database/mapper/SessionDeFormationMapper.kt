package com.papaours.sessionformation.serverside.adapter.database.mapper

import com.papaours.sessionformation.domain.model.SessionDeFormation
import com.papaours.sessionformation.serverside.adapter.database.entity.SessionDeFormationEntity
import com.papaours.sessionformation.serverside.adapter.database.entity.SessionDeFormationInformations
import java.time.LocalDate
import org.springframework.data.domain.Page
import org.springframework.data.domain.PageImpl

object SessionDeFormationMapper {
    fun SessionDeFormationEntity.toSessionDeFormation(): SessionDeFormation {
        if (informations == null) throw Error("Les informations de la session de formations ne devrait pas être vide")
        if (id == null) throw Error("L'id de l'entité Session de formation n'existe pas")
        return SessionDeFormation(
            id = id,
            nom = informations.nom,
            dateDeDebut = LocalDate.parse(informations.dateDeDebut),
            dateDeFin = LocalDate.parse(informations.dateDeFin),
            dateDeFinExamen = LocalDate.parse(informations.dateDeFinExamen),
            nombrePlaces = informations.nombrePlaces,
            volumeHoraireTotal = informations.volumeHoraireTotal,
            langue = informations.langue,
            statut = informations.statut,
            periodes = informations.periodes.map { it.toPeriode() },
            duree = informations.duree.toDuree(),
            formation = informations.formation.toFormation(),
            siteDeFormation = informations.siteDeFormation.toSiteDeFormation()
        )
    }

    private fun SessionDeFormationInformations.Periode.toPeriode() = SessionDeFormation.Periode(
        nom = nom,
        dateDeDebut = LocalDate.parse(dateDeDebut),
        dateDeFin = LocalDate.parse(dateDeFin)
    )

    private fun SessionDeFormationInformations.Formation.toFormation() = SessionDeFormation.Formation(
        identifiant = identifiant,
        intitule = intitule,
        intituleCours = intituleCours,
        statut = statut,
        conformite = conformite,
        type = type,
        description = description,
        diplome = SessionDeFormation.Formation.Diplome(
            nature = diplome.nature,
            description = diplome.description,
            niveau = diplome.niveau,
            intitule = diplome.intitule,
            code = SessionDeFormation.Formation.Diplome.CodeDiplome(diplome.code),
            typeDiplome = SessionDeFormation.Formation.Diplome.TypeDiplome(
                cle = diplome.typeDiplome.cle,
                valeur = diplome.typeDiplome.valeur,
                categorie = diplome.typeDiplome.categorie
            )
        ),
        certificationProfessionnel = SessionDeFormation.Formation.CertificationProfessionnel(
            code = certificationProfessionnel.code,
            type = certificationProfessionnel.type,
            abregeType = certificationProfessionnel.abregeType,
            volumeHoraireTotal = certificationProfessionnel.volumeHoraireTotal,
            libelle = certificationProfessionnel.libelle,
            statut = certificationProfessionnel.statut
        )
    )

    private fun SessionDeFormationInformations.SiteDeFormation.toSiteDeFormation() =
        SessionDeFormation.SiteDeFormation(
            siret = siret,
            nomLegal = nomLegal,
            nomCommercial = nomCommercial,
            statut = statut,
            ville = ville
        )

    private fun SessionDeFormationInformations.Duree.toDuree() =
        SessionDeFormation.Duree(
            volume = volume,
            temporalite = SessionDeFormation.Duree.Temporalite.fromString(temporalite)
        )


    fun Page<SessionDeFormationEntity>.toSessionDeFormation(): Page<SessionDeFormation> {
        if (this.content.isEmpty()) return PageImpl(emptyList())
        val sessionsDeFormation = this.content.map { it.toSessionDeFormation() }
        return PageImpl(sessionsDeFormation, this.pageable, this.totalElements)
    }
}
