package com.papaours.sessionformation.userside.adapter.controller.hateoas

import com.papaours.gestion.sessionformation.userside.restResources.RecupererSessionDeFormationRestResource
import com.papaours.sessionformation.userside.adapter.controller.SessionDeFormationController
import org.springframework.hateoas.EntityModel
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn

object SessionDeFormationHateoasMapper {
    fun RecupererSessionDeFormationRestResource.toEntityModel() :
            EntityModel<RecupererSessionDeFormationRestResource> {
        return EntityModel.of(this,
            linkTo(methodOn(SessionDeFormationController::class.java).recuperer(this.id)).withSelfRel())
    }
}

