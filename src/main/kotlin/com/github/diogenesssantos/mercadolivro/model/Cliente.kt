package com.github.diogenesssantos.mercadolivro.model

import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id


@Entity(name = "tb_cliente")
class Cliente(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private val id: Long?,

    var nome: String,
    var idade: Int
) {
    constructor(nome: String, idade: Int) : this(null, nome, idade)
}