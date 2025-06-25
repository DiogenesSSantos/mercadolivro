package com.github.diogenesssantos.mercadolivro.repository

import com.github.diogenesssantos.mercadolivro.model.Cliente
import jakarta.annotation.PostConstruct
import org.springframework.stereotype.Controller

@Controller
class ClienteRepositoryImpl() : ClienteRepository {


    companion object {
        private val listCliente: MutableList<Cliente>? = mutableListOf<Cliente>()

    }

    @PostConstruct
    fun alimentarLista() {
        listCliente?.addAll(
            listOf(
                Cliente("Diogenes", 28),
                Cliente("Diogo", 38),
                Cliente("Serverino", 65)
            )
        )

    }


    override fun buscarPorNome(nome: String): Cliente? {
        val clienteLocalizado = listCliente?.firstOrNull {
            cliente -> cliente.nome.equals(nome , true) }

        return clienteLocalizado
    }

    override  fun buscarTodosPorNome(filtro : String): MutableList<Cliente>? {
        val filter = listCliente?.filter { cliente -> cliente.nome.startsWith(filtro, true) }
        return filter?.toMutableList()
    }

}