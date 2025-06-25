package com.github.diogenesssantos.mercadolivro.repository

import com.github.diogenesssantos.mercadolivro.model.Cliente
import jakarta.annotation.PostConstruct
import org.springframework.stereotype.Controller

@Controller
class ClienteRepositoryImpl() : ClienteRepository {


    companion object {
         val listCliente: MutableList<Cliente>? = mutableListOf<Cliente>()

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
        return null
    }

    override  fun buscarTodosPorNome(filtro : String): MutableList<Cliente>? {
        return null
    }



}