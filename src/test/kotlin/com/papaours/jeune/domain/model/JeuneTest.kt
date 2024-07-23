package com.papaours.jeune.domain.model

import com.papaours.jeune.domain.exception.jeune.JeuneException
import com.papaours.jeune.domain.exception.jeune.securitesociale.NumeroDeSecuriteSocialeException
import com.papaours.jeune.fixture.JeuneFixture
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertDoesNotThrow
import org.junit.jupiter.api.assertThrows

class JeuneTest {
    @Test
    fun `quand je cree un jeune valide, il n'y a aucune exception de lancee`() {
        //GIVEN
        val mockValide = JeuneFixture.mockJeuneValide
        //WHEN
        fun creerJeuneValide():Jeune {
            return Jeune(
                id = mockValide.id,
                nom = mockValide.nom,
                prenom = mockValide.prenom,
                email = mockValide.email,
                dateNaissance = mockValide.dateNaissance,
                numeroSecuriteSociale = mockValide.numeroSecuriteSociale,
                validateur = mockValide.validateur
            )
        }

        assertDoesNotThrow { creerJeuneValide() }
    }

    @Test
    fun `quand je cree un jeune avec un email invalide, une exception est lancee`() {
        //GIVEN
        val mockValide = JeuneFixture.mockJeuneValide
        //WHEN
        fun creerJeuneAvecEmailInvalide():Jeune {
            return Jeune(
                id = mockValide.id,
                nom = mockValide.nom,
                prenom = mockValide.prenom,
                email = "email",
                dateNaissance = mockValide.dateNaissance,
                numeroSecuriteSociale = mockValide.numeroSecuriteSociale,
                validateur = mockValide.validateur
            )
        }
        //THEN
        assertThrows<JeuneException> {
            creerJeuneAvecEmailInvalide()
        }
    }
    @Test
    fun `quand je cree un jeune avec un numero de secu invalide , une exception est lancee`() {
        //GIVEN
        val mockValide = JeuneFixture.mockJeuneValide
        //WHEN
        fun creerJeuneAvecNssInvalide():Jeune {
            return Jeune(
                id = mockValide.id,
                nom = mockValide.nom,
                prenom = mockValide.prenom,
                email = mockValide.email,
                dateNaissance = mockValide.dateNaissance,
                numeroSecuriteSociale = Jeune.NumeroSecuriteSociale(mockValide.numeroSecuriteSociale.sexe,
                    mockValide.numeroSecuriteSociale.anneeNaissance,
                    mockValide.numeroSecuriteSociale.moisNaissance,
                    mockValide.numeroSecuriteSociale.departementNaissance,
                    mockValide.numeroSecuriteSociale.insee,
                    "1921",
                    "00",
                    mockValide.numeroSecuriteSociale.validateur),
                validateur = mockValide.validateur
            )
        }
        //THEN
        assertThrows<NumeroDeSecuriteSocialeException> {
            creerJeuneAvecNssInvalide()
        }
    }
}
