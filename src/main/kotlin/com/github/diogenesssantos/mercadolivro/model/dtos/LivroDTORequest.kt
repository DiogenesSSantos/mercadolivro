package com.github.diogenesssantos.mercadolivro.model.dtos

import com.fasterxml.jackson.annotation.JsonAlias

data class LivroDTORequest (
    val nome : String,
    @JsonAlias( "id_cliente")
    val clienteId : Long
)