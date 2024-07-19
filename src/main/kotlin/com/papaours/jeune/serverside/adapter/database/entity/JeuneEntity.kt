package com.papaours.jeune.serverside.adapter.database.entity

import java.util.*

data class JeuneEntity(
    val id: UUID? = null,
    val informations: JeuneInformations? = null
)

data class JeuneInformations(
    val nom: String,
    val prenom: String,
    val dateDeNaissance: String,
    val email: String,
    val numeroSecuriteSociale: String,
)
