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
public class PessoaFisica implements Pessoa {

    @Id String cpf;
    String nome;

    @JsonFormat(pattern="dd-MM-yyyy" , locale = "pt-BR", timezone = "Brazil/East")
    @Temporal(TemporalType.DATE)
    Date dataNascimento;

    @OneToOne
    @JoinColumn(name = "conta", referencedColumnName = "id")
    ContaMatriz conta;
}
