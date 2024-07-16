package com.papaours.sessionformation.domain.port.serverside

import com.papaours.sessionformation.domain.model.SessionDeFormation
import java.util.*

interface PourRecupererSessionsDeFormationParId {
    operator fun invoke(id: UUID) : SessionDeFormation
}
