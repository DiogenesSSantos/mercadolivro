package com.github.diogenesssantos.mercadolivro.service

import com.github.diogenesssantos.mercadolivro.exception.ClienteNaoLocalizadoException
import com.github.diogenesssantos.mercadolivro.infraestructure.AssemblerCliente
import com.github.diogenesssantos.mercadolivro.model.Cliente
import com.github.diogenesssantos.mercadolivro.model.dtos.ClienteDTO
import com.github.diogenesssantos.mercadolivro.model.dtos.ClienteResponse
import com.github.diogenesssantos.mercadolivro.repository.ClienteRepository
import com.github.diogenesssantos.mercadolivro.repository.ClienteRepositoryImpl.Companion.listCliente
import com.github.diogenesssantos.mercadolivro.repository.LivroRepository
import org.springframework.stereotype.Service

@Service
class ClienteService(val repository: ClienteRepository, val livroRepository : LivroRepository) {


    fun salvar(cliente: ClienteDTO): ClienteDTO {
        val clientePersistido: Cliente = repository.save(Cliente(cliente.nome, cliente.idade))

        return ClienteDTO(clientePersistido.nome, cliente.idade)
    }

    fun buscarPorId(id : Long): Cliente {
        val clienteLocalizado = repository.findById(id)
            .orElseThrow { ClienteNaoLocalizadoException() }

        return clienteLocalizado

    }


    fun buscarPorNome(nome: String): Cliente? {
        val clienteLocalizado: MutableList<Cliente> = repository.findAll()
        val firstOrNull = clienteLocalizado.firstOrNull() { cliente -> cliente.nome.equals(nome, true) }

        return firstOrNull
    }

    fun buscarTodosPorFiltro(nome: String): MutableList<Cliente>? {
        val listaCompleta: MutableList<Cliente>? = repository.findAll()

        nome?.let {
            return listaCompleta?.filter { cliente -> cliente.nome.startsWith(nome, true) }
                    as MutableList<Cliente>?
        }

        return listaCompleta
    }


    fun buscarLivrosDoCliente(idCLiente : Long) : ClienteResponse {

        try {
            var clienteLocalizado = buscarPorId(idCLiente)
            val buscarLivrosPorIdCliente = livroRepository.buscarLivrosPorIdCliente(idCLiente)
            return ClienteResponse(clienteLocalizado.nome , buscarLivrosPorIdCliente)

        } catch (e : ClienteNaoLocalizadoException) {
            print(e.message)
            return ClienteResponse()
        }

    }



}