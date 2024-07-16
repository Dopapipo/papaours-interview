package com.papaours.sessionformation.domain.usecase

import com.papaours.sessionformation.domain.model.SessionDeFormation
import com.papaours.sessionformation.domain.port.serverside.PourRechercherSessionsDeFormation
import com.papaours.sessionformation.domain.port.serverside.PourRecupererSessionsDeFormation
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.stereotype.Component

@Component
class RecupererSessionsDeFormation (
    private val pourRecupererSessionsDeFormationRepository: PourRecupererSessionsDeFormation,
    private val pourRechercherSessionsDeFormationRepository: PourRechercherSessionsDeFormation
){
  operator fun invoke(critere: String, pageable: Pageable): Page<SessionDeFormation> =
    if(critere.isBlank())
      pourRecupererSessionsDeFormationRepository(pageable)
    else
      pourRechercherSessionsDeFormationRepository(critere, pageable)
}
