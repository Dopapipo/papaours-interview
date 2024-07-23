package com.papaours.jeune.serverside.adapter.database.repository

import com.papaours.jeune.domain.model.Jeune
import com.papaours.jeune.serverside.adapter.database.mapper.JeuneMapper.toEntity
import com.papaours.jeune.serverside.adapter.database.mapper.JeuneMapper.toJeune
import org.springframework.stereotype.Repository

@Repository
class JeuneRepository {
    fun persist(jeune: Jeune): Jeune {
        //map jeune to jeune entity
        val jeuneEntity = jeune.toEntity()
        // persist somewhere using the db port [todo mais pas pour moi]
        val jeunePersisted = jeuneEntity
        // map persisted to jeune and return
        return jeunePersisted.toJeune()
    }
}
