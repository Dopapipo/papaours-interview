package com.papaours.sessionformation.domain.model

class CodeDiplomeFormatValidateur: FormatValidateur {
  override fun invoke(value: String?): Boolean = value != null
      && value.matches(Regex("\\d{8}\\w?"))
}