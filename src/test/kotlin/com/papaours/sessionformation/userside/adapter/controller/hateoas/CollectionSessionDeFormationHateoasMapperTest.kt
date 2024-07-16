package com.papaours.sessionformation.userside.adapter.controller.hateoas

import com.papaours.sessionformation.fixture.SessionDeFormationFixture
import com.papaours.sessionformation.userside.adapter.controller.hateoas.CollectionSessionDeFormationHateoasMapper.toCollectionModel
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.springframework.data.domain.PageImpl
import org.springframework.data.domain.PageRequest
import org.springframework.hateoas.Link

class CollectionSessionDeFormationHateoasMapperTest{
  @Test
  fun `Quand j'appelle mon mappeur avec des rest ressources valides, il me renvoie la collection model correspondante`(){
      //GIVEN
      val restResourceAttendu = listOf(
          SessionDeFormationFixture.mockRecupererSessionDeFormationRestRessource,
          SessionDeFormationFixture.mockRecupererSessionDeFormationRestRessource2
      )

      val critere = ""
      val recupererSessionsDeFormationAMapper = PageImpl(restResourceAttendu)
      //WHEN
      val sessionsDeFormationObtenue = recupererSessionsDeFormationAMapper.toCollectionModel(critere)
      //THEN
      assertThat(sessionsDeFormationObtenue.content.map{ it.content }).isEqualTo(restResourceAttendu)
  }

  @Test
  fun `Quand j'appelle mon mappeur avec plus de rest ressources valides que la taille de ma page, il me renvoie la collection model correspondante avec le lien pour la suivente`(){
      //GIVEN
    val restResourceAttendu = listOf(
        SessionDeFormationFixture.mockRecupererSessionDeFormationRestRessource
    )
    val critere = ""
    val pageable = PageRequest.of(0, 1)
    val recupererSessionsDeFormationAMapper = PageImpl(restResourceAttendu, pageable,2)

    val linkAttendu = Link.of("/v1/sessionsDeFormation?pageNumber=1&pageSize=1&critere=").withRel("Suivant")

    //WHEN
    val sessionsDeFormationObtenue = recupererSessionsDeFormationAMapper.toCollectionModel(critere)
    val linkObtenu = sessionsDeFormationObtenue.links.getRequiredLink("Suivant")
    //THEN
    assertThat(sessionsDeFormationObtenue.content.map{ it.content}).isEqualTo(restResourceAttendu)
    assertThat(linkObtenu.rel).isEqualTo(linkAttendu.rel)
    assertThat(linkObtenu.href).isEqualTo(linkAttendu.href)

  }

  @Test
  fun `Quand j'appelle mon mappeur avec des rest ressources valides et que je ne suis pas sur la première page, il me renvoie la collection model correspondante avec le lien pour la précédente`(){
    //GIVEN
    val restResourceAttendu = listOf(
        SessionDeFormationFixture.mockRecupererSessionDeFormationRestRessource
    )
    val critere = ""
    val pageable = PageRequest.of(1, 1)
    val recupererSessionsDeFormationAMapper = PageImpl(restResourceAttendu, pageable,2)

    val linkAttendu = Link.of("/v1/sessionsDeFormation?pageNumber=0&pageSize=1&critere=").withRel("Precedent")

    //WHEN
    val sessionsDeFormationObtenue = recupererSessionsDeFormationAMapper.toCollectionModel(critere)

    val linkObtenu = sessionsDeFormationObtenue.links.getRequiredLink("Precedent")
    //THEN
    assertThat(sessionsDeFormationObtenue.content.map{ it.content}).isEqualTo(restResourceAttendu)
    assertThat(linkObtenu.rel).isEqualTo(linkAttendu.rel)
    assertThat(linkObtenu.href).isEqualTo(linkAttendu.href)
  }
}