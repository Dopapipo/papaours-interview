package com.papaours.jeune.serverside.adapter.repository

import com.papaours.jeune.domain.model.Jeune
import com.papaours.jeune.domain.port.serverside.PourAjouterUnJeune
import com.papaours.jeune.serverside.adapter.database.repository.JeuneRepository
import org.springframework.stereotype.Repository

@Repository
class PourAjouterUnJeuneRepository(
    private val jeuneRepository: JeuneRepository
) : PourAjouterUnJeune {
    override fun invoke(jeune: Jeune): Jeune {
        return jeuneRepository.persist(jeune);
    }
}
