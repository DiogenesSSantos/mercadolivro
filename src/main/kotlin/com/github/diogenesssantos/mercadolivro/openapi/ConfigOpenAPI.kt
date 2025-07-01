package com.github.diogenesssantos.mercadolivro.openapi

import io.swagger.v3.oas.models.ExternalDocumentation
import io.swagger.v3.oas.models.OpenAPI
import io.swagger.v3.oas.models.info.Contact
import io.swagger.v3.oas.models.info.Info
import io.swagger.v3.oas.models.info.License
import org.springdoc.core.models.GroupedOpenApi
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class ConfigOpenAPI {

    @Bean
    fun openAPI(): OpenAPI {

        return OpenAPI()
            .info(
                Info()
                    .title("Mercado-Livro")
                    .description("API PARA CADASTRO DE LIVRO")
                    .version("1.0")
                    .contact(
                        Contact()
                            .name("Diogenes da silva santos")
                            .url("https://github.com/DiogenesSSantos")
                            .email("diogenescontatoofficial@hotmail.com")
                    ).license(License().name("MIT License").url("https://opensource.org/licenses/MIT"))

            )
    }


    @Bean
    fun clienteOpenApi(): GroupedOpenApi {
        return GroupedOpenApi
            .builder()
            .group("Cliente-Controller")
            .pathsToMatch("/cliente/**")
            .build()
    }


    @Bean
    fun livroOpenApi() : GroupedOpenApi {
        return GroupedOpenApi
            .builder()
            .group("Livro-Controller")
            .pathsToMatch("/livro/**")
            .build()

    }

}