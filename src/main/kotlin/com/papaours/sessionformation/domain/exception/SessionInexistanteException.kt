package com.papaours.sessionformation.domain.exception

import java.util.*

class SessionInexistanteException(
    private val idSession: UUID,
) : SessionFormationException() {
    override val message: String
        get() = "La session de formation avec l'id $idSession n'existe pas"
}
