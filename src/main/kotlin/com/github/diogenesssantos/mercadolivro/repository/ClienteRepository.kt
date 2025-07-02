package com.github.diogenesssantos.mercadolivro.repository

import com.github.diogenesssantos.mercadolivro.model.Cliente
import com.github.diogenesssantos.mercadolivro.model.dtos.ClienteDTO
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.repository.Repository
import org.springframework.stereotype.Controller

@org.springframework.stereotype.Repository
interface ClienteRepository : JpaRepository<Cliente, Long> {


}