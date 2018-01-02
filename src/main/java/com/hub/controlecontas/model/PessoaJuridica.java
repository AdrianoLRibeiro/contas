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
public class PessoaJuridica extends Pessoa {

    private String razaoSocial;
    private String nomeFantasia;

    public PessoaJuridica(String id, String razaoSocial, String nomeFantasia) {
        super(id);
        this.razaoSocial = razaoSocial;
        this.nomeFantasia = nomeFantasia;
    }
}
