package com.github.diogenesssantos.mercadolivro.model.dtos

import com.fasterxml.jackson.annotation.JsonProperty

data class LivroDTOResponse (
    val nome : String,


    @JsonProperty("cliente")
    val clienteDTO: ClienteDTO
)