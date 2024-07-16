package com.papaours.sessionformation.serverside.adapter.repository

import com.papaours.sessionformation.domain.model.SessionDeFormation
import com.papaours.sessionformation.domain.port.serverside.PourRecupererSessionsDeFormation
import com.papaours.sessionformation.serverside.adapter.database.mapper.SessionDeFormationMapper.toSessionDeFormation
import com.papaours.sessionformation.serverside.adapter.database.repository.SessionDeFormationInMemoryRepository
import org.springframework.data.domain.Page
import org.springframework.data.domain.PageImpl
import org.springframework.data.domain.Pageable
import org.springframework.stereotype.Repository

@Repository
class PourRecupererSessionsDeFormationRepository(
    private val sessionDeFormationInMemoryRepository: SessionDeFormationInMemoryRepository
) : PourRecupererSessionsDeFormation {
  override fun invoke(pageable : Pageable): Page<SessionDeFormation> {
    val page = sessionDeFormationInMemoryRepository.findAll(pageable)
    val sessionDeFormations = page.content.map { it.toSessionDeFormation() }

    return PageImpl(sessionDeFormations, page.pageable, page.totalElements)
  }
}
