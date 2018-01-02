package com.hub.controlecontas.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

import javax.persistence.*;
import javax.validation.Constraint;
import java.math.BigDecimal;
import java.util.Date;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
public class ContaFilial extends ContaMatriz {

    @ManyToOne(optional = false)
    @JoinColumn(name = "parent", referencedColumnName = "id")
    @JsonBackReference
    @NonNull
    ContaMatriz parent;

    public ContaFilial(String id, String nome, Date dataCriacao, Status status, BigDecimal saldo, ContaMatriz parent, Pessoa pessoa) {
        super(id, nome, dataCriacao, status, saldo, pessoa);
        this.parent = parent;
    }

    public void transferePara(ContaFilial conta, BigDecimal valor){

        runAllValidations(conta, valor);

        synchronized (this){
            this.subtrairValorSaldo(valor);
            conta.adicionaValorSaldo(valor);
        }

    }

    private void runAllValidations(ContaFilial conta, BigDecimal valor) {
        if (!(this instanceof ContaFilial)) {
            throw new RuntimeException("Somente contas Filiais podem realizar transferências");
        }

        if (this.contaNaoAtiva() || conta.contaNaoAtiva()) {
            throw new RuntimeException("Uma das contas nõa está ativa");
        }

        if (saldoNaoSuficiente(valor)) {
            throw new RuntimeException("O Saldo atual não é suficiente para realizar esta transferência");
        }

        if (this.arvoresDiferentes(conta)) {
            throw new RuntimeException("Contas Filiais de Pais diferentens não podem realizar transfêrencias");
        }
    }

    private boolean arvoresDiferentes(ContaFilial conta) {
        return !mesmaArvore(conta);
    }

    private boolean mesmaArvore(ContaFilial conta) {
        return this.getMatriz().equals(conta.getMatriz());
    }

    private ContaMatriz getMatriz() {
        if (getParent() instanceof ContaMatriz) {
            return getParent();
        }
        return getMatriz();
    }

    private void subtrairValorSaldo(BigDecimal valor){
        this.setSaldo(this.getSaldo().subtract(valor));
    }

    private void adicionaValorSaldo(BigDecimal valor){
        this.setSaldo(this.getSaldo().add(valor));
    }

    private boolean saldoNaoSuficiente(BigDecimal valor) {
        if (valor.compareTo(this.getSaldo()) == 1 ) {
            return true;
        }
        return false;
    }
}
