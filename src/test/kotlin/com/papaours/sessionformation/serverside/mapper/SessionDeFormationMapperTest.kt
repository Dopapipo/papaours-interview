package com.papaours.sessionformation.serverside.mapper

import com.papaours.sessionformation.fixture.SessionDeFormationFixture
import com.papaours.sessionformation.serverside.adapter.database.mapper.SessionDeFormationMapper.toSessionDeFormation
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class SessionDeFormationMapperTest {
  @Test
  fun `Quand j'appelle mon mapper avec un document de session de formation valide, il me renvoie la session de formation correspondante`(){
    //GIVEN
    val sessionDeFormationAttendue = SessionDeFormationFixture.mockSessionDeFormation
    val sessionDeFormationAMapper = SessionDeFormationFixture.mockSessionDeFormationEntitee
    //WHEN
    val sessionDeFormationObtenue = sessionDeFormationAMapper.toSessionDeFormation()
    //THEN
    assertThat(sessionDeFormationObtenue).usingRecursiveComparison()
      .ignoringFields("id")
      .isEqualTo(sessionDeFormationAttendue)
  }
}
