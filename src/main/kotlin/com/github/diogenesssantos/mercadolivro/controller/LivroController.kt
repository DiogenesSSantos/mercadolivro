package com.github.diogenesssantos.mercadolivro.controller

import com.github.diogenesssantos.mercadolivro.model.dtos.LivroDTORequest
import com.github.diogenesssantos.mercadolivro.model.dtos.LivroDTOResponse
import com.github.diogenesssantos.mercadolivro.service.ClienteService
import com.github.diogenesssantos.mercadolivro.service.LivroService
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController


@RestController
@RequestMapping(path = ["/livro"])
class LivroController(val clienteService: ClienteService, val LivroService: LivroService) {

    @GetMapping
    fun buscarTodos() : ResponseEntity<List<LivroDTOResponse>?> {

        val LocalizadoTodos = LivroService.buscarTodos()
        return ResponseEntity.ok().body(LocalizadoTodos)
    }


    @PostMapping
    fun criar(@RequestBody livroDTORequest: LivroDTORequest): ResponseEntity<LivroDTOResponse>? {
        val clienteLocalizado = clienteService.buscarPorId(livroDTORequest.clienteId)
        val livroResponse = LivroService.criar(livroDTORequest, clienteLocalizado)
        return ResponseEntity.status(HttpStatus.CREATED)
            .body(livroResponse)
    }




}