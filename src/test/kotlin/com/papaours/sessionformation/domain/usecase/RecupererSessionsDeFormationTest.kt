package com.papaours.sessionformation.domain.usecase

import com.papaours.sessionformation.domain.port.serverside.PourRechercherSessionsDeFormation
import com.papaours.sessionformation.domain.port.serverside.PourRecupererSessionsDeFormation
import com.papaours.sessionformation.fixture.SessionDeFormationFixture
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith
import org.mockito.Mock
import org.mockito.Mockito.`when`
import org.mockito.junit.jupiter.MockitoExtension
import org.springframework.data.domain.PageImpl
import org.springframework.data.domain.PageRequest

@ExtendWith(MockitoExtension::class)
class RecupererSessionsDeFormationTest{
  @Mock
  lateinit var pourRecupererSessionsDeFormation : PourRecupererSessionsDeFormation
  @Mock
  lateinit var pourRechercherSessionsDeFormation : PourRechercherSessionsDeFormation

  @Test
  fun `Quand j'appelle mon usecase avec des informations valides, il me renvoie une page de session de formation`(){
      //GIVEN
      val sessionsDeFormationAttendues = SessionDeFormationFixture.mockSessionDeFormation
      val pageable = PageRequest.of(0, 10)
      val recupererSessionsDeFormation = RecupererSessionsDeFormation(
          pourRecupererSessionsDeFormation,
          pourRechercherSessionsDeFormation
      )
      `when`(pourRecupererSessionsDeFormation(pageable))
          .thenReturn(PageImpl(listOf( sessionsDeFormationAttendues)))

      //WHEN
      val sessionsDeFormationRetournees = recupererSessionsDeFormation("", pageable)

      //THEN
      assertThat(sessionsDeFormationRetournees).isEqualTo(PageImpl(listOf(sessionsDeFormationAttendues)))
  }
}
