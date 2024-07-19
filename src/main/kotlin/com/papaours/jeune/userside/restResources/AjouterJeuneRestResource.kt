package com.papaours.jeune.userside.restResources

import jakarta.validation.constraints.Email
import jakarta.validation.constraints.NotEmpty
import jakarta.validation.constraints.NotNull
import jakarta.validation.constraints.Size
import org.springframework.format.annotation.DateTimeFormat

data class AjouterJeuneRestResource(
    @NotEmpty(message = "Le prénom ne doit pas être vide")
    @NotNull
    val prenom: String,
    @NotEmpty(message = "Le nom ne doit pas être vide")
    @NotNull
    val nom: String,
    @Email(message = "L'adresse mail doit être valide")
    @NotNull
    val mail: String,
    @DateTimeFormat(pattern = "dd-MM-yyyy", iso = DateTimeFormat.ISO.DATE)
    @NotNull
    val dateDeNaissance: String,
    @NotEmpty(message = "Le numéro de sécurité sociale ne doit pas être vide")
    @Size(min = 15, max = 15, message = "Le numéro de sécurité sociale doit contenir 15 caractères")
    @NotNull
    val numeroSecuriteSociale: String
)
