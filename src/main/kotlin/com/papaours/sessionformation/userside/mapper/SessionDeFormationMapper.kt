package com.papaours.gestion.sessionformation.userside.mapper

import com.papaours.sessionformation.domain.model.SessionDeFormation
import com.papaours.sessionformation.userside.adapter.controller.hateoas.CollectionSessionDeFormationHateoasMapper.toCollectionModel
import com.papaours.gestion.sessionformation.userside.restResources.RecupererSessionDeFormationRestResource
import org.springframework.data.domain.Page
import org.springframework.data.domain.PageImpl
import org.springframework.hateoas.CollectionModel
import org.springframework.hateoas.EntityModel

object SessionDeFormationMapper {
    private fun List<SessionDeFormation>.toRestRessource(): List<RecupererSessionDeFormationRestResource> =
        this.map { sessionDeFormation ->
            with(sessionDeFormation) {
                RecupererSessionDeFormationRestResource(
                    id = id,
                    nom = nom,
                    intituleFormation = formation.intitule,
                    codeRNCP = formation.certificationProfessionnel.code,
                    nomDiplome = formation.diplome.intitule,
                    codeDiplome = formation.diplome.code.value,
                    nomSiteFormation = siteDeFormation.nomLegal,
                    dateDebut = dateDeDebut.toString(),
                    dateFin = dateDeFin.toString(),
                    duree = duree.toString(),
                    tauxCompletion = tauxCompletion().value
                )
            }
        }

    fun SessionDeFormation.toRecupererRestRessource(): RecupererSessionDeFormationRestResource =
        with(this) {
            RecupererSessionDeFormationRestResource(
                id = id,
                nom = nom,
                intituleFormation = formation.intitule,
                codeRNCP = formation.certificationProfessionnel.code,
                nomDiplome = formation.diplome.intitule,
                codeDiplome = formation.diplome.code.value,
                nomSiteFormation = siteDeFormation.nomLegal,
                dateDebut = dateDeDebut.toString(),
                dateFin = dateDeFin.toString(),
                duree = duree.toString(),
                tauxCompletion = tauxCompletion().value
            )
        }

    fun Page<SessionDeFormation>.toRestResource(critere: String): CollectionModel<EntityModel<RecupererSessionDeFormationRestResource>> {
        val sessionDeFormationRestRessource = this.content.toRestRessource()
        return PageImpl(sessionDeFormationRestRessource, this.pageable, this.totalElements).toCollectionModel(critere)
    }
}
