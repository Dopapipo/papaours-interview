package com.papaours.jeune.userside.mapper

import com.papaours.jeune.domain.model.Jeune
import com.papaours.jeune.domain.model.JeuneValidateur
import com.papaours.jeune.domain.model.NSSValidateur
import com.papaours.jeune.userside.restResources.AjouterJeuneRestResource
import org.springframework.hateoas.EntityModel
import java.time.LocalDate
import java.util.*

object JeuneMapper {
    fun AjouterJeuneRestResource.toJeune(): Jeune {
        return Jeune(
            id = UUID.randomUUID(),
            email = this.mail,
            prenom = this.prenom,
            nom = this.nom,
            dateNaissance = mapToLocalDate(this.dateDeNaissance),
            numeroSecuriteSociale = mapToNumeroDeSecuriteSociale(this.numeroSecuriteSociale),
            validateur = JeuneValidateur()
        )
    }

    fun AjouterJeuneRestResource.toEntityModel(): EntityModel<AjouterJeuneRestResource> {
        return EntityModel.of(this)
    }

    fun Jeune.toAjouterJeuneRestResource(): AjouterJeuneRestResource {
        return AjouterJeuneRestResource(
            mail = this.email,
            prenom = this.prenom,
            nom = this.nom,
            dateDeNaissance = this.dateNaissance.toString(),
            numeroSecuriteSociale = this.numeroSecuriteSociale.toString()
        )
    }

    private fun mapToLocalDate(date: String, format: String = "eu"): LocalDate {
        val dateArray = date.split("-")
        return LocalDate.of(dateArray[2].toInt(), dateArray[1].toInt(), dateArray[0].toInt())
    }

    private fun mapToNumeroDeSecuriteSociale(numeroSecu: String): Jeune.NumeroSecuriteSociale {
        val sexe = numeroSecu.substring(0, 1)
        val annee = numeroSecu.substring(1, 3)
        val mois = numeroSecu.substring(3, 5)
        val departement = numeroSecu.substring(5, 7)
        val insee = numeroSecu.substring(7, 10)
        val ordre = numeroSecu.substring(10, 13)
        val cle = numeroSecu.substring(13, 15)
        return Jeune.NumeroSecuriteSociale(
            sexe = sexe,
            anneeNaissance = annee,
            moisNaissance = mois,
            departementNaissance = departement,
            insee = insee,
            ordreEnregistrement = ordre,
            cle = cle,
            validateur = NSSValidateur()
        )
    }
}
