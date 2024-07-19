package com.papaours.jeune.userside.adapter.controller

import com.papaours.jeune.domain.exception.jeune.JeuneException
import com.papaours.jeune.domain.exception.jeune.securitesociale.NumeroDeSecuriteSocialeException
import com.papaours.jeune.userside.adapter.controller.exception.JeuneExceptionResponse
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.RestControllerAdvice

@RestControllerAdvice
class JeuneControllerAdvice {
    @ExceptionHandler(JeuneException::class)
    fun handleJeuneExceptions(e: JeuneException): ResponseEntity<JeuneExceptionResponse> =
        ResponseEntity.status(HttpStatus.BAD_REQUEST).body(
            JeuneExceptionResponse(
                message = e.message
            )
        )

    @ExceptionHandler(NumeroDeSecuriteSocialeException::class)
    fun handleNumeroSecuExceptions(e: NumeroDeSecuriteSocialeException): ResponseEntity<JeuneExceptionResponse> =
        ResponseEntity.status(HttpStatus.BAD_REQUEST).body(
            JeuneExceptionResponse(
                message = e.message
            )
        )
}
