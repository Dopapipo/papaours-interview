package com.papaours.jeune.domain.usecase

import com.papaours.jeune.domain.model.Jeune
import com.papaours.jeune.domain.port.serverside.PourAjouterUnJeune
import org.springframework.stereotype.Component

@Component
class AjouterUnJeune(private val pourAjouterUnJeune: PourAjouterUnJeune) {
    operator fun invoke(jeune: Jeune) = pourAjouterUnJeune(jeune)
}
