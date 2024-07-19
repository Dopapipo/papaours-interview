package com.papaours.jeune.userside.adapter.controller.hateoas

import com.papaours.jeune.userside.adapter.controller.JeuneController
import com.papaours.jeune.userside.restResources.AjouterJeuneRestResource
import org.springframework.hateoas.EntityModel
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn

object JeuneHateoasMapper {
    fun AjouterJeuneRestResource.toEntityModel():
            EntityModel<AjouterJeuneRestResource> {
        return EntityModel.of(
            this,
            linkTo(methodOn(JeuneController::class.java).ajouter(this)).withSelfRel()
        )
    }

}
