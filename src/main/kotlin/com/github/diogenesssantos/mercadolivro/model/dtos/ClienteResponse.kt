package com.github.diogenesssantos.mercadolivro.model.dtos

import com.fasterxml.jackson.annotation.JsonProperty

data class ClienteResponse (
    val clienteNome: String?,

    @JsonProperty(value = "livros")
    val ListaLivroClient: List<String>?


){

    constructor():this("" , listOf()){

    }


}
