package com.github.diogenesssantos.mercadolivro.controller

import com.github.diogenesssantos.mercadolivro.infraestructure.AssemblerCliente
import com.github.diogenesssantos.mercadolivro.model.dtos.ClienteDTO
import com.github.diogenesssantos.mercadolivro.openapi.ClienteControlerAPIDocumentacao
import com.github.diogenesssantos.mercadolivro.service.ClienteService
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController


@RestController
@RequestMapping(path = ["/cliente"])
class ClienteController(val clienteService: ClienteService) : ClienteControlerAPIDocumentacao{



    @PostMapping
    fun salvar(@RequestBody clienteDTO : ClienteDTO) : ResponseEntity<ClienteDTO> {
        var clienteDTO = clienteService.salvar(clienteDTO)

        return ResponseEntity.ok(clienteDTO)

    }



    @GetMapping
    override fun buscarPorNome(@RequestParam("nome") nome: String): ResponseEntity<ClienteDTO?>? {
        val clienteLocalizado = clienteService.buscarPorNome(nome)

        clienteLocalizado?.let {
            return ResponseEntity.ok()
                .body(AssemblerCliente.clienteTODto(clienteLocalizado))

        }

        return ResponseEntity.noContent().build()
    }


    @GetMapping("/buscarTodos")
    override fun buscarTodosPorFiltro(@RequestParam("nome") nome: String) : ResponseEntity<Any> {
       return ResponseEntity.ok(clienteService.buscarTodosPorFiltro(nome))
    }

}