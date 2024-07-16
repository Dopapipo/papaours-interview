package com.papaours.sharedkernel.configuration

import io.swagger.v3.oas.annotations.OpenAPIDefinition
import io.swagger.v3.oas.annotations.info.Info
import org.springdoc.core.models.GroupedOpenApi
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration


@Configuration
@OpenAPIDefinition(
    info = Info(
        title = "API Papaours Gestion",
        version = "v1",
        description = "Documentation globale de l'API Papaours Gestion"
    )
)
class SwaggerConfiguration {

    @Bean
    fun formationApi(): GroupedOpenApi {
        return GroupedOpenApi.builder()
            .group("Session de formation")
            .pathsToMatch("/v1/sessionsDeFormation/**")
            .packagesToScan("com.papaours.sessionformation")
            .build()
    }
}