package com.papaours.jeune.serverside.adapter.database.mapper

import com.papaours.jeune.domain.model.Jeune
import com.papaours.jeune.domain.model.JeuneValidateur
import com.papaours.jeune.serverside.adapter.database.entity.JeuneEntity
import com.papaours.jeune.serverside.adapter.database.entity.JeuneInformations
import com.papaours.jeune.userside.mapper.JeuneMapper
import com.papaours.jeune.userside.mapper.JeuneMapper.format
import java.time.LocalDate

object JeuneMapper {
    fun JeuneEntity.toJeune(): Jeune {
        if (this.informations == null) {
            throw Error("Les informations du jeune ne devraient pas etre vides")
        }
        if (id == null) {
            throw Error("L'id du jeune n'existe pas.")
        }
        return Jeune(
            id = this.id,
            nom = this.informations.nom,
            prenom = this.informations.prenom,
            dateNaissance = this.informations.dateDeNaissance.toLocalDate(),
            email = this.informations.email,
            // ce que j'aimerais faire: pouvoir soit overload le constructeur du nss,
            // soit faire Jeune.NumeroDeSecuriteSociale.of(this.informations.numeroSecuriteSociale)
            numeroSecuriteSociale = JeuneMapper.mapToNumeroDeSecuriteSociale(this.informations.numeroSecuriteSociale),
            validateur = JeuneValidateur()
        )
    }

    private fun String.toLocalDate(): LocalDate {
        try {
            val dateArray = this.split("-")
            return LocalDate.of(dateArray[2].toInt(), dateArray[1].toInt(), dateArray[0].toInt())
        } catch (e: Exception) {
            throw Error("La date de naissance doit être au format jj-mm-aaaa")
        }
    }

    fun Jeune.toEntity(): JeuneEntity {
        return JeuneEntity(
            id = this.id,
            informations = JeuneInformations(
                nom = this.nom,
                prenom = this.prenom,
                dateDeNaissance = this.dateNaissance.format(),
                email = this.email,
                numeroSecuriteSociale = this.numeroSecuriteSociale.toString()
            )
        )
    }
}
