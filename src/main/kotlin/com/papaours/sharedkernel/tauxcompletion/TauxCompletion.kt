package com.papaours.sharedkernel.tauxcompletion

data class TauxCompletion(val value: Int = 0) {
    init {
        require(value in 0..100) { "Le taux de complétion doit être compris entre 0 et 100." }
    }
}
