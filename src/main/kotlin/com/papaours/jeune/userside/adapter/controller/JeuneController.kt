package com.papaours.jeune.userside.adapter.controller

import com.papaours.jeune.domain.usecase.AjouterUnJeune
import com.papaours.jeune.userside.adapter.controller.documentation.JeuneControllerDocumentation
import com.papaours.jeune.userside.adapter.controller.hateoas.JeuneHateoasMapper.toEntityModel
import com.papaours.jeune.userside.mapper.JeuneMapper.toAjouterJeuneRestResource
import com.papaours.jeune.userside.mapper.JeuneMapper.toJeune
import com.papaours.jeune.userside.restResources.AjouterJeuneRestResource
import jakarta.validation.Valid
import java.net.URI
import org.springframework.hateoas.EntityModel
import org.springframework.http.ResponseEntity
import org.springframework.validation.annotation.Validated
import org.springframework.web.bind.annotation.*
import java.util.UUID

@RestController
@Validated
@RequestMapping("/v1/jeunes")
class JeuneController(val ajouterUnJeune: AjouterUnJeune) : JeuneControllerDocumentation {
    // TODO?: renvoyer un ResponseEntity<RechercherJeuneRestResource>
    @GetMapping("/{id}")
    fun getJeuneById(@PathVariable id: UUID): ResponseEntity<AjouterJeuneRestResource> {
        val jeune = AjouterJeuneRestResource(
            nom = "Gomez",
            prenom = "Pedro",
            mail = "pedrogomez@gomezcorp.com",
            dateDeNaissance = "05-12-1999",
            numeroSecuriteSociale = "199123123123296"
        )
        return ResponseEntity.ok().body(jeune)
    }

    @PostMapping
    override fun ajouter(@Valid @RequestBody ajouterJeuneRestResource: AjouterJeuneRestResource): ResponseEntity<EntityModel<AjouterJeuneRestResource>> {
        val jeune = ajouterJeuneRestResource.toJeune()
        val jeuneAjoute = ajouterUnJeune(jeune)
        val jeuneRestResourceResponse = jeuneAjoute.toAjouterJeuneRestResource().toEntityModel()
        val location = "/v1/jeunes/${jeuneAjoute.id}"
        return ResponseEntity.created(URI.create(location)).body(jeuneRestResourceResponse)
    }
}
