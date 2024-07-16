package com.papaours.sessionformation.userside.adapter.controller

import com.papaours.gestion.sessionformation.userside.mapper.SessionDeFormationMapper.toRecupererRestRessource
import com.papaours.gestion.sessionformation.userside.mapper.SessionDeFormationMapper.toRestResource
import com.papaours.gestion.sessionformation.userside.restResources.RecupererSessionDeFormationRestResource
import com.papaours.sessionformation.domain.usecase.RecupererSessionDeFormation
import com.papaours.sessionformation.domain.usecase.RecupererSessionsDeFormation
import com.papaours.sessionformation.userside.adapter.controller.documentation.SessionDeFormationControllerDocumentation
import com.papaours.sessionformation.userside.adapter.controller.hateoas.SessionDeFormationHateoasMapper.toEntityModel
import java.util.*
import org.springframework.data.domain.PageRequest
import org.springframework.hateoas.CollectionModel
import org.springframework.hateoas.EntityModel
import org.springframework.http.ResponseEntity
import org.springframework.validation.annotation.Validated
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController

@RestController
@Validated
@RequestMapping("/v1/sessionsDeFormation")
class SessionDeFormationController(
    val recupererSessionsDeFormation: RecupererSessionsDeFormation,
    val recupererSessionDeFormation: RecupererSessionDeFormation
) : SessionDeFormationControllerDocumentation {
    @GetMapping
    override fun rechercher(
        @RequestParam("pageNumber", defaultValue = "0") pageNumber: Int,
        @RequestParam("pageSize", defaultValue = "10") pageSize: Int,
        @RequestParam("critere", defaultValue = "") critere: String
    ): ResponseEntity<CollectionModel<EntityModel<RecupererSessionDeFormationRestResource>>> {
        val pageable = PageRequest.of(pageNumber, pageSize)

        val sessionsDeFormationPage = recupererSessionsDeFormation(critere, pageable)

        val sessionsDeFormationRestPage = sessionsDeFormationPage.toRestResource(critere)
        return ResponseEntity.ok(sessionsDeFormationRestPage)
    }

    @GetMapping("/{id}")
    override fun recuperer(
        @PathVariable("id") id: UUID
    ): ResponseEntity<EntityModel<RecupererSessionDeFormationRestResource>> {
        val sessionDeFormation = recupererSessionDeFormation(id)
        val sessionDeFormationRest = sessionDeFormation.toRecupererRestRessource().toEntityModel()
        return ResponseEntity.ok(sessionDeFormationRest)
    }
}
