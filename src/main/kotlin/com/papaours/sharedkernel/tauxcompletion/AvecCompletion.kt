package com.papaours.sharedkernel.tauxcompletion

abstract class AvecCompletion {
    fun estComplet(): Boolean = tauxCompletion().value == 100
    abstract fun tauxCompletion(): TauxCompletion
}