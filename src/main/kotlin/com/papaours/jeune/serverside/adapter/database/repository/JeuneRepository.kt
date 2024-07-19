package com.papaours.jeune.serverside.adapter.database.repository

import com.papaours.jeune.domain.model.Jeune
import org.springframework.stereotype.Repository

@Repository
class JeuneRepository {
    fun persist(jeune: Jeune): Jeune {
        //map jeune to jeune entity [todo]
        // persist
        // map persisted to jeune [todo]
        //return persisted
        // [on ne demande pas l'impl donc je retourne juste le jeune]
        return jeune;
    }
}
