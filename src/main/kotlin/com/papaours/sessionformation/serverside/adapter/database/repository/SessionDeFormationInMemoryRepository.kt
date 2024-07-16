package com.papaours.sessionformation.serverside.adapter.database.repository

import com.papaours.sessionformation.serverside.adapter.database.entity.MockSessionDeFormationEntity
import com.papaours.sessionformation.serverside.adapter.database.entity.SessionDeFormationEntity
import java.util.*
import org.springframework.data.domain.Page
import org.springframework.data.domain.PageImpl
import org.springframework.data.domain.Pageable
import org.springframework.stereotype.Repository

@Repository
class SessionDeFormationInMemoryRepository {

    fun findAll(pageable: Pageable): Page<SessionDeFormationEntity> {
        val mockSessionDeFormationEntity = MockSessionDeFormationEntity.mockSessionDeFormationEntity

        val mockSessionDeFormationEntities = listOf(mockSessionDeFormationEntity)
        return PageImpl(mockSessionDeFormationEntities, pageable, mockSessionDeFormationEntities.size.toLong())
    }

    fun rechercherParMotCle(term: String, pageable: Pageable): Page<SessionDeFormationEntity> {
        val mockSessionDeFormationEntity = MockSessionDeFormationEntity.mockSessionDeFormationEntity

        val mockSessionDeFormationEntities = listOf(mockSessionDeFormationEntity)
        return PageImpl(mockSessionDeFormationEntities, pageable, mockSessionDeFormationEntities.size.toLong())
    }

    fun findById(id: UUID): SessionDeFormationEntity {
        return MockSessionDeFormationEntity.mockSessionDeFormationEntity
    }
}