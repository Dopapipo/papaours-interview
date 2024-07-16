package com.papaours.sessionformation.domain.model

import com.papaours.sessionformation.domain.exception.FormatInvalideException

open class Validateur (value: String, validateur: FormatValidateur) {
    init {
        if (!validateur(value)) {
            throw FormatInvalideException("La valeur : $value est invalide")
        }
    }
}