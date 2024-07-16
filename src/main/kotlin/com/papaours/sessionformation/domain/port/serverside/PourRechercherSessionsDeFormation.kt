package com.papaours.sessionformation.domain.port.serverside

import com.papaours.sessionformation.domain.model.SessionDeFormation
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable

interface PourRechercherSessionsDeFormation {
  operator fun invoke(critere: String, pageable: Pageable) : Page<SessionDeFormation>
}
