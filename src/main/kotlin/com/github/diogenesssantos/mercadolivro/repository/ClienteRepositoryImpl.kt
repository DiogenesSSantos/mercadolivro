package com.github.diogenesssantos.mercadolivro.repository

import com.github.diogenesssantos.mercadolivro.model.Cliente
import com.github.diogenesssantos.mercadolivro.model.dtos.ClienteDTO
import jakarta.annotation.PostConstruct
import jakarta.persistence.EntityManager
import jakarta.persistence.EntityManagerFactory
import org.hibernate.jpa.boot.spi.EntityManagerFactoryBuilder
import org.springframework.context.annotation.Lazy
import org.springframework.stereotype.Controller

@Controller
class ClienteRepositoryImpl()  {

    companion object {
         val listCliente: MutableList<Cliente>? = mutableListOf<Cliente>()
    }



}