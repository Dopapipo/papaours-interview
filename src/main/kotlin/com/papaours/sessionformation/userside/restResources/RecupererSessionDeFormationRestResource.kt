package com.papaours.gestion.sessionformation.userside.restResources

import java.util.UUID

data class RecupererSessionDeFormationRestResource(
    val id: UUID,
    val nom: String,
    val intituleFormation: String,
    val codeRNCP: String,
    val nomDiplome: String,
    val codeDiplome: String,
    val nomSiteFormation: String,
    val dateDebut: String,
    val dateFin: String,
    val duree: String,
    val tauxCompletion: Int? = null
)
