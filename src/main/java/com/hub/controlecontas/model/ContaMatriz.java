package com.hub.controlecontas.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

@Data
@Builder
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS )
public class ContaMatriz implements Serializable{

    @Id private String id;
    private String nome;

    @JsonFormat(pattern="dd-MM-yyyy" , locale = "pt-BR", timezone = "Brazil/East")
    @Temporal(TemporalType.DATE)
    private Date dataCriacao;
    private Status status;
    private BigDecimal saldo;

    @OneToOne
    @JoinColumn(name = "pessoa", referencedColumnName = "id")
    Pessoa pessoa;

    protected boolean contaNaoAtiva() {
        if (this.getStatus().equals(Status.BLOQUEADA) ||
        this.getStatus().equals(Status.CANCELADA)) {
                return true;
        }
        return false;
    }

    public final void aporte(BigDecimal valor) {

        if (!(this instanceof ContaMatriz)) {
            throw new RuntimeException("Somente contas Matriz pode realizar aportes");
        }
        this.saldo.add(valor);
    }

    public enum Status {
        BLOQUEADA,
        CANCELADA,
        ATIVA;
    }
}
