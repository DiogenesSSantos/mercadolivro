package com.github.diogenesssantos.mercadolivro

import com.github.diogenesssantos.mercadolivro.repository.LivroRepository
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest


@SpringBootTest
class LivroRepositoryTest(@Autowired val repository: LivroRepository) {


    @Test
    fun buscarTodosLivrosPorIdCliente() {

        val listaPorIdCliente = repository.buscarLivrosPorIdCliente(1L)
        println(listaPorIdCliente)
    }


}