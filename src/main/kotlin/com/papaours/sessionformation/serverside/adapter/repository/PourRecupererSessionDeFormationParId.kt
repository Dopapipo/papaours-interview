package com.papaours.sessionformation.serverside.adapter.repository

import com.papaours.sessionformation.domain.port.serverside.PourRecupererSessionsDeFormationParId
import com.papaours.sessionformation.domain.model.SessionDeFormation
import com.papaours.sessionformation.serverside.adapter.database.mapper.SessionDeFormationMapper.toSessionDeFormation
import com.papaours.sessionformation.serverside.adapter.database.repository.SessionDeFormationInMemoryRepository
import java.util.*
import org.springframework.stereotype.Repository

@Repository
class PourRecupererSessionDeFormationParId(
    private val sessionDeFormationInMemoryRepository: SessionDeFormationInMemoryRepository
) : PourRecupererSessionsDeFormationParId {
    override fun invoke(id: UUID): SessionDeFormation {
        return sessionDeFormationInMemoryRepository.findById(id).toSessionDeFormation()
    }
}
