package com.papaours.jeune.domain.port.serverside

import com.papaours.jeune.domain.model.Jeune

interface PourAjouterUnJeune {
    operator fun invoke(jeune: Jeune): Jeune
}
