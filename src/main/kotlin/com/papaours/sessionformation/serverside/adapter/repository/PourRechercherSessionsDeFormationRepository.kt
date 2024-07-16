package com.papaours.sessionformation.serverside.adapter.repository

import com.papaours.sessionformation.domain.model.SessionDeFormation
import com.papaours.sessionformation.domain.port.serverside.PourRechercherSessionsDeFormation
import com.papaours.sessionformation.serverside.adapter.database.mapper.SessionDeFormationMapper.toSessionDeFormation
import com.papaours.sessionformation.serverside.adapter.database.repository.SessionDeFormationInMemoryRepository
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.stereotype.Repository

@Repository
class PourRechercherSessionsDeFormationRepository (
    private val sessionDeFormationInMemoryRepository: SessionDeFormationInMemoryRepository
): PourRechercherSessionsDeFormation {
  override fun invoke(
      critere: String, pageable: Pageable
  ): Page<SessionDeFormation> {
    val sessionsDeFormationsEntitees = sessionDeFormationInMemoryRepository.rechercherParMotCle(critere, pageable)
    return sessionsDeFormationsEntitees.toSessionDeFormation()
  }
}
