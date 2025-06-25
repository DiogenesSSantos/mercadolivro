package com.github.diogenesssantos.mercadolivro.service

import com.github.diogenesssantos.mercadolivro.model.Cliente
import com.github.diogenesssantos.mercadolivro.repository.ClienteRepository
import com.github.diogenesssantos.mercadolivro.repository.ClienteRepositoryImpl.Companion.listCliente
import org.springframework.stereotype.Service

@Service
class ClienteService(val repository : ClienteRepository) {


    fun buscarPorNome (nome : String) : Cliente? {
         val clienteLocalizado = listCliente?.firstOrNull {
                cliente -> cliente.nome.equals(nome , true) }

        return clienteLocalizado
    }

    fun buscarTodosPorFiltro (nome : String) : MutableList<Cliente>? {
        val filter = listCliente?.filter { cliente -> cliente.nome.startsWith(nome, true) }
        return filter?.toMutableList()

    }

}