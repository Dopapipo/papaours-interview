package com.papaours.jeune.domain.exception.jeune

abstract class JeuneException:RuntimeException() {
    abstract override val message: String
}
