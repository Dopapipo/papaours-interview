package com.papaours.sessionformation.userside.mapper

import com.papaours.sessionformation.fixture.SessionDeFormationFixture
import com.papaours.gestion.sessionformation.userside.mapper.SessionDeFormationMapper.toRestResource
import org.assertj.core.api.Assertions
import org.junit.jupiter.api.Test
import org.springframework.data.domain.PageImpl
import org.springframework.hateoas.EntityModel

class SessionDeFormationMapperTest {

  @Test
  fun `Quand j'appelle mon mapper avec une page de session de formation valide, il me renvoie la resource rest correspondante`(){
    //GIVEN
    val restResourceAttendue = EntityModel.of(SessionDeFormationFixture.mockRecupererSessionDeFormationRestRessource)
    val sessionDeFormationAMapper = PageImpl(listOf( SessionDeFormationFixture.mockSessionDeFormation))
    //WHEN
    val sessionDeFormationObtenue = sessionDeFormationAMapper.toRestResource("")
    //THEN
    Assertions.assertThat(sessionDeFormationObtenue.content.elementAt(0)).isEqualTo(restResourceAttendue)
  }

  @Test
  fun `Quand j'appelle mon mapper avec une page de session de formation valide et dont le volume de duree est de 1, il me renvoie la resource rest correspondante avec une temporalité au singulier`(){
    //GIVEN
    val restResourceAttendue = EntityModel.of(SessionDeFormationFixture.mockRecupererSessionDeFormationRestRessource2)
    val sessionDeFormationAMapper = PageImpl(listOf( SessionDeFormationFixture.mockSessionDeFormation2))
    //WHEN
    val sessionDeFormationObtenue = sessionDeFormationAMapper.toRestResource("")
    //THEN
    Assertions.assertThat(sessionDeFormationObtenue.content.elementAt(0)).isEqualTo(restResourceAttendue)
  }
}
