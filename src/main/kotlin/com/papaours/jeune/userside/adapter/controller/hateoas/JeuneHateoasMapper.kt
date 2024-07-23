package com.papaours.jeune.userside.adapter.controller.hateoas

import com.papaours.jeune.serverside.adapter.database.mapper.JeuneMapper.toEntity
import com.papaours.jeune.userside.adapter.controller.JeuneController
import com.papaours.jeune.userside.mapper.JeuneMapper.toJeune
import com.papaours.jeune.userside.restResources.AjouterJeuneRestResource
import org.springframework.hateoas.EntityModel
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn
// TODO: parler de ça
object JeuneHateoasMapper {
    fun AjouterJeuneRestResource.toEntityModel():
            EntityModel<AjouterJeuneRestResource> {
        return EntityModel.of(
            this,
            linkTo(methodOn(JeuneController::class.java).getJeuneById(this.toJeune().id)).withSelfRel()
        )
    }

}
