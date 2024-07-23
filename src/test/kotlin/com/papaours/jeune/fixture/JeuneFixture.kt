package com.papaours.jeune.fixture

import com.papaours.jeune.domain.model.Jeune
import com.papaours.jeune.domain.model.JeuneValidateur
import com.papaours.jeune.domain.model.NSSValidateur
import com.papaours.jeune.serverside.adapter.database.entity.JeuneEntity
import com.papaours.jeune.serverside.adapter.database.entity.JeuneInformations
import com.papaours.jeune.userside.restResources.AjouterJeuneRestResource
import java.time.LocalDate
import java.util.*

class JeuneFixture {
    companion object {
        val mockJeuneValide = Jeune(
            id = UUID.fromString("a84fe4a6-fba9-4005-8ce1-a255b01491cc"),
            dateNaissance = LocalDate.of(1999, 12, 5),
            email = "pedrogomez@gomezcorp.com",
            nom = "Gomez",
            prenom = "Pedro",
            numeroSecuriteSociale = Jeune.NumeroSecuriteSociale(
                sexe = "1",
                anneeNaissance = "99",
                moisNaissance = "12",
                departementNaissance = "31",
                insee = "231",
                ordreEnregistrement = "232",
                cle = "96",
                validateur = NSSValidateur()
            ),
            validateur = JeuneValidateur()
        )

        val mockAjouterJeuneRestResourceValide = AjouterJeuneRestResource(
            nom = "Gomez",
            prenom = "Pedro",
            mail = "pedrogomez@gomezcorp.com",
            dateDeNaissance = "05-12-1999",
            numeroSecuriteSociale = "199123123123296"
        )
        val mockJeuneEntity = JeuneEntity(
            id = UUID.fromString("a84fe4a6-fba9-4005-8ce1-a255b01491cc"),
            informations = JeuneInformations(
                nom = "Gomez",
                prenom = "Pedro",
                dateDeNaissance = "05-12-1999",
                email = "pedrogomez@gomezcorp.com",
                numeroSecuriteSociale = "199123123123296"
            )
        )
    }
}
