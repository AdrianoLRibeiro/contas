package com.hub.controlecontas.controller;

import com.hub.controlecontas.database.service.PessoaFisicaService;
import com.hub.controlecontas.model.ContaMatriz;
import com.hub.controlecontas.model.PessoaFisica;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

import static java.util.Arrays.asList;

@RestController
@RequestMapping(value="/pessoa-fisica")
public class PessoaFisicaController {

    @Autowired
    PessoaFisicaService service;

    @RequestMapping(method= RequestMethod.GET)
    public List<PessoaFisica> getAll() {
        System.out.println("teste");
        System.out.println(service.getAll());
        ContaMatriz conta = ContaMatriz.builder()
            .id("00")
            .nome("getAll")
            .dataCriacao(new Date())
            .status(ContaMatriz.Status.ATIVA)
            .build();
        return asList(PessoaFisica.builder()
            .cpf("000")
            .nome("nome fisica")
            .dataNascimento(new Date())
            .conta(conta)
            .build());
    }

    @RequestMapping(method= RequestMethod.POST)
    public void save(@RequestBody PessoaFisica pessoaFisica) {
        System.out.println(pessoaFisica);
    }

    @RequestMapping(method= RequestMethod.PUT)
    public void update(@RequestBody PessoaFisica pessoaFisica) {
        System.out.println(pessoaFisica);
    }

    @RequestMapping(value="/{id}", method= RequestMethod.GET)
    public PessoaFisica getById(@PathVariable("id") String id) {

        System.out.println(id);
        return null;
    }

    @RequestMapping(value="/{id}", method= RequestMethod.DELETE)
    public ResponseEntity delete(@PathVariable("id") String id) {

        System.out.println(id);
        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }
}
