package com.github.diogenesssantos.mercadolivro.controller

import com.github.diogenesssantos.mercadolivro.infraestructure.AssemblerCliente
import com.github.diogenesssantos.mercadolivro.model.dtos.ClienteDTO
import com.github.diogenesssantos.mercadolivro.service.ClienteService
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController


@RestController
@RequestMapping(path = ["/clientes"])
class ClienteController(val clienteService: ClienteService) {


    @GetMapping
    fun buscarPorNome(@RequestParam("nome") nome: String): ResponseEntity<Any> {
        val clienteLocalizado = clienteService.buscarPorNome(nome)
        clienteLocalizado?.let {
//            val clienteDTO = ClienteDTO(clienteLocalizado.nome, clienteLocalizado.idade)
            return ResponseEntity.ok()
                .body(AssemblerCliente.clienteTODto(clienteLocalizado))

        }

        return ResponseEntity.noContent().build()
    }


    @GetMapping("/buscarTodos")
    fun buscarTodosPorFiltro(@RequestParam("nome") nome: String) : ResponseEntity<Any> {
       return ResponseEntity.ok(clienteService.buscarTodosPorFiltro(nome))
    }

}