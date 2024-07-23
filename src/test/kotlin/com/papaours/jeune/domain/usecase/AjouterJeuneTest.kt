package com.papaours.jeune.domain.usecase

import com.papaours.jeune.domain.port.serverside.PourAjouterUnJeune
import com.papaours.jeune.fixture.JeuneFixture
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith
import org.mockito.Mock
import org.mockito.Mockito.`when`
import org.mockito.junit.jupiter.MockitoExtension

@ExtendWith(MockitoExtension::class)
class AjouterJeuneTest {
    @Mock
    lateinit var pourAjouterUnJeune: PourAjouterUnJeune

    @Test
    fun `Quand j'appelle mon usecase avec un JeuneRestResource valide, je recois le jeune valide`() {
        // GIVEN
        val jeuneValide = JeuneFixture.mockJeuneValide
        val ajouterUnJeune = AjouterUnJeune(pourAjouterUnJeune);
        `when`(pourAjouterUnJeune(jeuneValide))
            .thenReturn(jeuneValide)

        //WHEN
        val jeuneRetourne = ajouterUnJeune(jeuneValide)

        //THEN
        assertThat(jeuneRetourne).isEqualTo(jeuneValide)

    }
}
