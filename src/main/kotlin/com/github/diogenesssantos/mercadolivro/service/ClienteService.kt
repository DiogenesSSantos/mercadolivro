package com.github.diogenesssantos.mercadolivro.service

import com.github.diogenesssantos.mercadolivro.model.Cliente
import com.github.diogenesssantos.mercadolivro.repository.ClienteRepository
import org.springframework.stereotype.Service

@Service
class ClienteService(val repository : ClienteRepository) {


    fun buscarPorNome (nome : String) : Cliente? {
        return  repository.buscarPorNome(nome)
    }

    fun buscarTodosPorFiltro (nome : String) : MutableList<Cliente>? {
        return  repository.buscarTodosPorNome(nome)
    }

}