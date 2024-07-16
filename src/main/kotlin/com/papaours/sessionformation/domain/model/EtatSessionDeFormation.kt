package com.papaours.sessionformation.domain.model

import com.papaours.sharedkernel.tauxcompletion.TauxCompletion

class EtatSessionDeFormation {

    fun recupererChampsInvalides(sessionDeFormation: SessionDeFormation): List<ChampInvalide> {
        val listChampsInvalides = mutableListOf<ChampInvalide>()
        if (sessionDeFormation.statut == "Desactivée")
            listChampsInvalides.add(ChampInvalide("status", "Le status de la formation doit être actif"))
        return listChampsInvalides
    }
    fun tauxCompletion(sessionDeFormation: SessionDeFormation): TauxCompletion {
        return TauxCompletion(100)
    }

    data class ChampInvalide(
        val champ: String,
        val description: String
    )
}
