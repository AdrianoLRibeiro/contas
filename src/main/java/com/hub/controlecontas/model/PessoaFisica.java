package com.hub.controlecontas.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PessoaFisica extends Pessoa {

    String nome;

    @JsonFormat(pattern="dd-MM-yyyy" , locale = "pt-BR", timezone = "Brazil/East")
    @Temporal(TemporalType.DATE)
    Date dataNascimento;

    public PessoaFisica(String id, String nome, Date dataNascimento) {
        super(id);
        this.nome = nome;
        this.dataNascimento = dataNascimento;
    }
}
