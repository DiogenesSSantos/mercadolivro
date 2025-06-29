package com.github.diogenesssantos.mercadolivro.openapi

import io.swagger.v3.oas.models.ExternalDocumentation
import io.swagger.v3.oas.models.OpenAPI
import io.swagger.v3.oas.models.info.Contact
import io.swagger.v3.oas.models.info.Info
import io.swagger.v3.oas.models.info.License
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class ConfigOpenAPI {

    @Bean
    fun openAPI(): OpenAPI {

        return OpenAPI()
            .info(Info().title("Kotlin").description("Alguma coisa"))




//       return OpenAPI().apply {
//
//            info = Info().apply {
//                title = "Integração WhatsApp - Agendamento de Saúde"
//                description = """
//                Esta API foi criada para integrar o canal de comunicação via WhatsApp
//                com os sistemas de agendamento da Regulação de Saúde.
//                A proposta é melhorar o fluxo de informações, permitindo que pacientes
//                recebam notificações, lembretes e possam até mesmo confirmar ou
//                reagendar compromissos diretamente pelo aplicativo.
//                Essa abordagem visa reduzir faltas.
//            """.trimIndent()
//                version = "1.0.0"
//
//                contact = Contact().apply {
//                    name = "Diogenes"
//                    email = "diogenescontatoofficial@hotmail.com"
//                    url = "https://github.com/DiogenesSSantos"
//                }
//
//                license = License().apply {
//                    name = "MIT License"
//                    url = "https://opensource.org/licenses/MIT"
//                }
//            }
//
//            externalDocs = ExternalDocumentation().apply {
//                description = "Documentação JavaDoc"
//                url = "http://devdiogenes.shop/apidocs/index.html"
//            }
//        }
    }


}