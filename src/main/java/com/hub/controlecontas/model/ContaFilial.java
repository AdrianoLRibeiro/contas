package com.hub.controlecontas.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.util.Date;

@Entity
@NoArgsConstructor
@AllArgsConstructor
public class ContaFilial extends ContaMatriz {

    @ManyToOne
    @JoinColumn(name = "parent", referencedColumnName = "id")
    ContaMatriz conta;

    public ContaFilial(String id, String nome, Date dataCriacao, Status status) {
        super(id, nome, dataCriacao, status);
    }
}
