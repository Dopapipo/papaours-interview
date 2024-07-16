package com.papaours.sessionformation.userside.adapter.controller.documentation

import com.papaours.gestion.sessionformation.userside.restResources.RecupererSessionDeFormationRestResource
import io.swagger.v3.oas.annotations.Operation
import io.swagger.v3.oas.annotations.Parameter
import io.swagger.v3.oas.annotations.media.Content
import io.swagger.v3.oas.annotations.media.Schema
import io.swagger.v3.oas.annotations.responses.ApiResponse
import io.swagger.v3.oas.annotations.responses.ApiResponses
import io.swagger.v3.oas.annotations.security.SecurityRequirement
import io.swagger.v3.oas.annotations.tags.Tag
import jakarta.validation.constraints.Max
import jakarta.validation.constraints.Min
import java.util.*
import org.springframework.hateoas.CollectionModel
import org.springframework.hateoas.EntityModel
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.PathVariable

@Tag(
    name = "Session de formation", description = "### API pour la gestion des sessions de formation \n" +
    "Elle permet de consulter les différentes **sessions de formation** nécessaires à la création d'un dossier."
)
interface SessionDeFormationControllerDocumentation {
  @Operation(
      summary = "Récupére les sessions de formation",
      description = "Récupére les sessions de formation"
  )
  @ApiResponses(
      value = [
        ApiResponse(
            responseCode = "200",
            description = "l'ensemble des sessions de formation"
        )
      ]
  )
  fun rechercher(
      @Min(0) pageNumber: Int,
      @Min(1) @Max(20) pageSize: Int,
      critere: String
  ) : ResponseEntity<CollectionModel<EntityModel<RecupererSessionDeFormationRestResource>>>

    @Operation(
        summary = "Récupère une session de formation spécifique",
        description = "Récupère une session de formation par son ID",
        security = [SecurityRequirement(name = "bearerAuth")]
    )
    @ApiResponses(
        value = [
            ApiResponse(
                responseCode = "200",
                description = "Détails d'une session de formation",
                content = [Content(mediaType = "application/json",
                    schema = Schema(implementation = RecupererSessionDeFormationRestResource::class)
                )]
            ),
            ApiResponse(
                responseCode = "404",
                description = "Session de formation non trouvée"
            )
        ]
    )
    fun recuperer(
        @Parameter(description = "ID de la session de formation à récupérer", required = true)
        @PathVariable id: UUID
    ): ResponseEntity<EntityModel<RecupererSessionDeFormationRestResource>>

}
