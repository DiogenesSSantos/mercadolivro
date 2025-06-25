package com.github.diogenesssantos.mercadolivro.repository

import com.github.diogenesssantos.mercadolivro.model.Cliente
import org.springframework.stereotype.Controller

@Controller
interface ClienteRepository {
    fun buscarPorNome( nome : String) : Cliente?
    fun buscarTodosPorNome (nome : String) : MutableList<Cliente>?



}