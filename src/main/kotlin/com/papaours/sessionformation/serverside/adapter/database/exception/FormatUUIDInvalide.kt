package com.papaours.sessionformation.serverside.adapter.database.exception

import com.papaours.sessionformation.domain.exception.SessionFormationException
import java.util.*

class FormatUUIDInvalide(
    val id: UUID,
) : SessionFormationException() {
  override val message: String
    get() = "Format de l'id invalide : $id"
}
