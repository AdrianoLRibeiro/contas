package com.hub.controlecontas.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PessoaJuridica implements Pessoa {

    @Id String cnpj;
    String razaoSocial;
    String nomeFantasia;

    @OneToOne
    @JoinColumn(name = "conta", referencedColumnName = "id")
    ContaMatriz conta;
}
