package com.github.diogenesssantos.mercadolivro.repository

import com.github.diogenesssantos.mercadolivro.model.Livro
import org.springframework.data.jpa.repository.JpaRepository

interface LivroRepository : JpaRepository<Livro , Long> {
}