package com.github.diogenesssantos.mercadolivro.infraestructure

import com.github.diogenesssantos.mercadolivro.model.Cliente
import com.github.diogenesssantos.mercadolivro.model.dtos.ClienteDTO


/**
 * @author diogenesssantos
 * a classe assemble server para conversão de model de negocio para modelos representacionais!*
*/

class AssemblerCliente {
    companion object {

        public  fun clienteTODto ( cliente : Cliente) : ClienteDTO {
            return ClienteDTO(cliente.nome , cliente.idade)
        }

        public  fun dtoToCliente ( clienteDTO: ClienteDTO ) : Cliente {
            return Cliente(1, clienteDTO.nome , clienteDTO.idade)
        }

    }



}