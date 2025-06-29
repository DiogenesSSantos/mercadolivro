package com.github.diogenesssantos.mercadolivro.exception

import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.ResponseStatus

@ResponseStatus(code = HttpStatus.NOT_FOUND)
class ClienteNaoLocalizadoException(message: String = "CLIENTE NÃO LOCALIZADO NA BASE DE DADOS") : RuntimeException(message) {

}