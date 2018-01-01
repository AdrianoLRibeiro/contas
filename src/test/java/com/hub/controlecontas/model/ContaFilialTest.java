package com.hub.controlecontas.model;

import org.junit.Before;
import org.junit.Test;

import java.math.BigDecimal;
import java.util.Date;

import static com.hub.controlecontas.model.ContaMatriz.Status.*;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

public class ContaFilialTest {

    ContaMatriz matriz;
    ContaMatriz matriz2;

    ContaFilial c1;
    ContaFilial c2;
    ContaFilial c3;

    @Before
    public void setUp() {
        matriz = ContaMatriz.builder()
            .id("11")
            .nome("matriz")
            .dataCriacao(new Date())
            .status(ContaMatriz.Status.ATIVA)
            .saldo(new BigDecimal(100))
            .build();

         matriz2 = ContaMatriz.builder()
            .id("22")
            .nome("matriz 2")
            .dataCriacao(new Date())
            .status(ContaMatriz.Status.ATIVA)
            .saldo(new BigDecimal(100))
            .build();

        c1 = new ContaFilial("11", "conta filial 1", new Date(), ATIVA, new BigDecimal(100), matriz);
        c2 = new ContaFilial("22", "conta filial 2", new Date(), ATIVA, new BigDecimal(100), matriz);
        c3 = new ContaFilial("33", "conta filial 3", new Date(), ATIVA, new BigDecimal(100), matriz2);

    }

    @Test(expected = RuntimeException.class)
    public void transferenciaValorContasArvoresDiferentes() {
        c1.transferePara(c3, new BigDecimal(20));
    }

    @Test
    public void transferenciaBasicaValores() {
        c1.transferePara(c2, new BigDecimal(20));
        assertThat(c2.getSaldo(), is(new BigDecimal(120)));
        assertThat(c1.getSaldo(), is(new BigDecimal(80)));
    }

    @Test(expected = RuntimeException.class)
    public void transferenciaValorInsuficiente() {
        c1.transferePara(c2, new BigDecimal(120));
        assertThat(c2.getSaldo(), is(new BigDecimal(100)));
        assertThat(c1.getSaldo(), is(new BigDecimal(100)));
    }

    @Test(expected = ClassCastException.class)
    public void transferenciaValorContaMatrizNaoDeveSerPermitida() {
        c1.transferePara((ContaFilial) matriz, new BigDecimal(20));
    }

    @Test(expected = RuntimeException.class)
    public void transferenciaContaBloqueada() {
        c1.setStatus(BLOQUEADA);
        c1.transferePara(c2, new BigDecimal(20));
    }

    @Test(expected = RuntimeException.class)
    public void transferenciaContaCancelada() {
        c2.setStatus(CANCELADA);
        c1.transferePara(c2, new BigDecimal(20));
    }


}
