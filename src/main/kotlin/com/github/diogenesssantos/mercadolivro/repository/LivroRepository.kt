package com.github.diogenesssantos.mercadolivro.repository

import com.github.diogenesssantos.mercadolivro.model.Livro
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query
import org.springframework.stereotype.Repository

@Repository
interface LivroRepository : JpaRepository<Livro , Long> {

    @Query(
        "SELECT l.nome FROM Livro l WHERE l.cliente.id= :idCliente"
    )
    fun buscarLivrosPorIdCliente(idCliente : Long): List<String>
}