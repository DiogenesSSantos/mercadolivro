package com.github.diogenesssantos.mercadolivro.openapi

import com.github.diogenesssantos.mercadolivro.model.Cliente
import com.github.diogenesssantos.mercadolivro.model.dtos.ClienteDTO
import io.swagger.v3.oas.annotations.Operation
import io.swagger.v3.oas.annotations.tags.Tag
import org.springframework.http.ResponseEntity

@Tag(name = "Cliente Controller" , description = "Descricao do controller")
interface ClienteControlerAPIDocumentacao {


    @Operation(summary = "Filtra por nome " , description = "teste @Swagger")
    fun buscarPorNome(filtro : String) : ResponseEntity<ClienteDTO?>?


    fun buscarTodosPorFiltro(nome: String) : ResponseEntity<Any>


}