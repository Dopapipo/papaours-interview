package com.papaours.sessionformation.domain.port.serverside

import com.papaours.sessionformation.domain.model.SessionDeFormation
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable

fun interface PourRecupererSessionsDeFormation {
  operator fun invoke(pageable : Pageable): Page<SessionDeFormation>
}
