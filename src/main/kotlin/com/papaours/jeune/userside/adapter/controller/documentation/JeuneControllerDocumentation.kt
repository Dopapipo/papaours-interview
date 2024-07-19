package com.papaours.jeune.userside.adapter.controller.documentation

import com.papaours.jeune.userside.restResources.AjouterJeuneRestResource
import io.swagger.v3.oas.annotations.Operation
import io.swagger.v3.oas.annotations.media.Content
import io.swagger.v3.oas.annotations.media.Schema
import io.swagger.v3.oas.annotations.parameters.RequestBody
import io.swagger.v3.oas.annotations.responses.ApiResponse
import io.swagger.v3.oas.annotations.responses.ApiResponses
import io.swagger.v3.oas.annotations.tags.Tag
import jakarta.validation.Valid
import org.springframework.hateoas.EntityModel
import org.springframework.http.ResponseEntity

@Tag(
    name = "Jeune", description = "### API pour la gestion des jeunes \n" +
            "Elle permet de creer des jeunes afin de le referencer dans un contrat d'apprentissage."
)

interface JeuneControllerDocumentation {
    @Operation(
        summary = "Ajoute un jeune",
        description = "Ajoute un jeune avec une requete POST"
    )
    @ApiResponses(
        value = [
            ApiResponse(
                responseCode = "200",
                description = "Le jeune est ajoute"
            ),
            ApiResponse(
                responseCode = "400",
                description = "Requete invalide"
            )
        ]
    )
    fun ajouter(
        @RequestBody(
            description = "Informations du jeune à créer.<br>**Date de naissance (format attendu: dd-MM-yyyy)**",
            required = true,
            content = [Content(
                mediaType = "application/json",
                schema = Schema(implementation = AjouterJeuneRestResource::class),

                )]
        )
        @Valid ajouterJeuneRestResource: AjouterJeuneRestResource
    ): ResponseEntity<EntityModel<AjouterJeuneRestResource>>
}
