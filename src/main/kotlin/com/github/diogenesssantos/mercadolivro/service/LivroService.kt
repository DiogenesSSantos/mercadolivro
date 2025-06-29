package com.github.diogenesssantos.mercadolivro.service

import com.github.diogenesssantos.mercadolivro.infraestructure.AssemblerCliente
import com.github.diogenesssantos.mercadolivro.model.Cliente
import com.github.diogenesssantos.mercadolivro.model.Livro
import com.github.diogenesssantos.mercadolivro.model.dtos.LivroDTORequest
import com.github.diogenesssantos.mercadolivro.model.dtos.LivroDTOResponse
import com.github.diogenesssantos.mercadolivro.repository.LivroRepository
import org.springframework.stereotype.Service

@Service
class LivroService(val livroRepository: LivroRepository) {


    fun criar(livroDTORequest: LivroDTORequest, cliente: Cliente): LivroDTOResponse {
        livroRepository.save(Livro(livroDTORequest.nome,cliente))
        return LivroDTOResponse(livroDTORequest.nome , AssemblerCliente.clienteTODto(cliente))
    }

    fun buscarTodos() : List<LivroDTOResponse> {
        val livroListaBD = livroRepository.findAll()

        return livroListaBD.stream()
            .map {livro -> LivroDTOResponse(livro.nome , AssemblerCliente.clienteTODto(livro.cliente)) }
            .toList()
    }

}