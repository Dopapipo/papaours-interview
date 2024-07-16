package com.papaours.sessionformation.userside.adapter.controller

import com.papaours.sessionformation.domain.exception.FormatInvalideException
import com.papaours.sessionformation.domain.exception.SessionFormationException
import com.papaours.sessionformation.domain.exception.SessionInexistanteException
import com.papaours.sessionformation.serverside.adapter.database.exception.FormatUUIDInvalide
import com.papaours.sessionformation.userside.adapter.controller.exception.SessionFormationExceptionResponse
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.RestControllerAdvice

@RestControllerAdvice
class SessionDeFormationControllerAdvice {
  @ExceptionHandler(SessionInexistanteException::class)
  fun handleNotFoundExceptions(
      e: SessionFormationException
  ): ResponseEntity<SessionFormationExceptionResponse> =
    ResponseEntity.status(HttpStatus.NOT_FOUND).body(
        SessionFormationExceptionResponse(
            message = e.message
        )
    )

  @ExceptionHandler(FormatUUIDInvalide::class)
  fun handleBadRequestExceptions(
      e: FormatUUIDInvalide
  ): ResponseEntity<SessionFormationExceptionResponse> =
      ResponseEntity.status(HttpStatus.BAD_REQUEST).body(
          SessionFormationExceptionResponse(
              message = e.message
          )
      )

  @ExceptionHandler(FormatInvalideException::class)
  fun handleBadRequestExceptions(
      e: FormatInvalideException
  ): ResponseEntity<SessionFormationExceptionResponse> =
      ResponseEntity.status(HttpStatus.BAD_REQUEST).body(
          SessionFormationExceptionResponse(
              message = e.message
          )
      )
}