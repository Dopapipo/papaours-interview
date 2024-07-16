package com.papaours.sessionformation.userside.adapter.controller.hateoas

import com.papaours.gestion.sessionformation.userside.restResources.RecupererSessionDeFormationRestResource
import com.papaours.sessionformation.userside.adapter.controller.SessionDeFormationController
import org.springframework.data.domain.Page
import org.springframework.hateoas.CollectionModel
import org.springframework.hateoas.EntityModel
import org.springframework.hateoas.Link
import org.springframework.hateoas.PagedModel
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn

object CollectionSessionDeFormationHateoasMapper {
  fun Page<RecupererSessionDeFormationRestResource>.toCollectionModel(critere : String) :
      CollectionModel<EntityModel<RecupererSessionDeFormationRestResource>>
  {
    val sessionDeFormationModel = this.content.map{
      sessionDeFormation ->
      EntityModel.of(sessionDeFormation)
    }

    val pagedModelBuilder = PagedModel.of(
        sessionDeFormationModel,
        this.toMetadata()
    )

    recupererSuivant(critere, this)?.let { pagedModelBuilder.add(it) }
    recupererPrecedent(critere, this)?.let { pagedModelBuilder.add(it) }

    return pagedModelBuilder
  }

  private fun recupererSuivant(
      critere: String,
      page: Page<RecupererSessionDeFormationRestResource>,
  ) : Link? =
      if (!page.hasNext())
        null
      else linkTo(
          methodOn(SessionDeFormationController::class.java)
              .rechercher(page.number + 1, page.size, critere))
          .withRel("Suivant")


  private fun recupererPrecedent(
      critere: String,
      page: Page<RecupererSessionDeFormationRestResource>,
  ) : Link? =
      if (!page.hasPrevious())
        null
      else linkTo(
          methodOn(SessionDeFormationController::class.java)
              .rechercher(page.number - 1, page.size, critere))
          .withRel("Precedent")

  private fun Page<RecupererSessionDeFormationRestResource>.toMetadata() = PagedModel.PageMetadata(
      this.size.toLong(),
      this.number.toLong(),
      this.totalElements,
      this.totalPages.toLong()
  )
}