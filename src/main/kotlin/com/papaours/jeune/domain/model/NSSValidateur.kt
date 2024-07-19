package com.papaours.jeune.domain.model

import com.papaours.jeune.domain.exception.jeune.securitesociale.*

class NSSValidateur {

    operator fun invoke(numeroSecuriteSociale: Jeune.NumeroSecuriteSociale) {
        if (!validerSexe(numeroSecuriteSociale)) {
            throw SexeInvalideException()
        }
        if (!validerAnneeNaissance(numeroSecuriteSociale)) {
            throw AnneeDeNaissanceInvalideException()
        }
        if (!validerMoisNaissance(numeroSecuriteSociale)) {
            throw MoisDeNaissanceInvalideException()
        }
        if (!validerInsee(numeroSecuriteSociale)) {
            throw NumeroInseeInvalideException()
        }
        if (!validerCle(numeroSecuriteSociale)) {
            throw CleDeDeSecuriteInvalideException()
        }
    }

    private fun validerSexe(numeroSecuriteSociale: Jeune.NumeroSecuriteSociale): Boolean {
        return numeroSecuriteSociale.sexe == "1" || numeroSecuriteSociale.sexe == "2"
    }

    private fun validerAnneeNaissance(numeroSecuriteSociale: Jeune.NumeroSecuriteSociale): Boolean {
        return numeroSecuriteSociale.anneeNaissance.length == 2
    }

    private fun validerMoisNaissance(numeroSecuriteSociale: Jeune.NumeroSecuriteSociale): Boolean {
        return numeroSecuriteSociale.moisNaissance.matches(Regex("^(0[1-9]|1[0-2])\$"))
    }

    private fun validerInsee(numeroSecuriteSociale: Jeune.NumeroSecuriteSociale): Boolean {
        return numeroSecuriteSociale.insee.matches(Regex("^[0-9]{3}\$"))
    }

    private fun validerCle(numeroSecuriteSociale: Jeune.NumeroSecuriteSociale): Boolean {
        val cle = numeroSecuriteSociale.cle.toInt()
        val cleCalculee = calculerCle(numeroSecuriteSociale)
        return cle == cleCalculee
    }

    private fun calculerCle(numeroSecuriteSociale: Jeune.NumeroSecuriteSociale): Int {
        val nss =
            numeroSecuriteSociale.sexe + numeroSecuriteSociale.anneeNaissance + numeroSecuriteSociale.moisNaissance + numeroSecuriteSociale.departementNaissance + numeroSecuriteSociale.insee + numeroSecuriteSociale.ordreEnregistrement
        return (97 - nss.toInt()) % 97
    }
}
