package com.papaours.jeune.serverside.mapper

import com.papaours.jeune.fixture.JeuneFixture
import com.papaours.jeune.serverside.adapter.database.mapper.JeuneMapper.toEntity
import com.papaours.jeune.serverside.adapter.database.mapper.JeuneMapper.toJeune
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class JeuneMapperTest {
    @Test
    fun `quand je map un jeune valide a un JeuneEntity, le mapping est correct`() {
        //GIVEN
        val jeuneValide = JeuneFixture.mockJeuneValide
        //WHEN
        val jeuneEntity = jeuneValide.toEntity()
        //THEN
        assertThat(jeuneEntity).usingRecursiveComparison().ignoringFields("id").isEqualTo(JeuneFixture.mockJeuneEntity)
    }

    @Test
    fun `quand je map un JeuneEntity a un Jeune, le mapping est correct`() {
        //GIVEN
        val jeuneEntity = JeuneFixture.mockJeuneEntity
        //WHEN
        val jeune = jeuneEntity.toJeune()
        //THEN
        assertThat(jeune).usingRecursiveComparison().ignoringFields("id").isEqualTo(JeuneFixture.mockJeuneValide)
    }

}
