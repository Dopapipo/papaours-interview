package com.papaours.jeune.userside.mapper

import com.papaours.jeune.fixture.JeuneFixture
import com.papaours.jeune.userside.mapper.JeuneMapper.toAjouterJeuneRestResource
import com.papaours.jeune.userside.mapper.JeuneMapper.toJeune
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class JeuneMapperTest {
    @Test
    fun `quand je map un jeune a un AjouterJeuneRestResource, le mapping est correct`() {
        //GIVEN
        val jeune = JeuneFixture.mockJeuneValide
        //WHEN
        val jeuneRestResource = jeune.toAjouterJeuneRestResource()
        //THEN
        assertThat(jeuneRestResource).isEqualTo(JeuneFixture.mockAjouterJeuneRestResourceValide)
    }
    @Test
    fun `quand je map un AjouterJeuneRestResource a un jeune, le mapping est correct`() {
        //GIVEN
        val jeuneRestResource = JeuneFixture.mockAjouterJeuneRestResourceValide
        //WHEN
        val jeune = jeuneRestResource.toJeune()
        //THEN
        assertThat(jeune).usingRecursiveComparison().ignoringFields("id","validateur").isEqualTo(JeuneFixture.mockJeuneValide)
    }

}
