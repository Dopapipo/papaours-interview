package com.papaours.sessionformation.domain.usecase

import com.papaours.sessionformation.serverside.adapter.repository.PourRecupererSessionDeFormationParId
import java.util.*
import org.springframework.stereotype.Component

@Component
class RecupererSessionDeFormation(
    private val pourRecupererSessionDeFormationParId: PourRecupererSessionDeFormationParId
) {
    operator fun invoke(id: UUID) = pourRecupererSessionDeFormationParId(id)
}
