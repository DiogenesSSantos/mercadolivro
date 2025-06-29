package com.github.diogenesssantos.mercadolivro.model

import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.persistence.JoinColumn
import jakarta.persistence.ManyToOne

@Entity(name = "tb_livro")
class Livro(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private val id: Long?,

    private var nome: String,

    @ManyToOne
    @JoinColumn(name = "id_cliente")
    private var cliente: Cliente,

    ) {

    constructor(nome : String , cliente : Cliente ) : this(null , nome , cliente){}

}