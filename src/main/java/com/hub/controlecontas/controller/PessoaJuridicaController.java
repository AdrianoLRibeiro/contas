package com.hub.controlecontas.controller;

import com.hub.controlecontas.database.dao.PessoaJuridicaDAO;
import com.hub.controlecontas.database.service.PessoaJuridicaService;
import com.hub.controlecontas.model.ContaMatriz;
import com.hub.controlecontas.model.PessoaJuridica;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

import static java.util.Arrays.asList;

@RestController
@RequestMapping(value="/pessoa-juridica")
public class PessoaJuridicaController {

    @Autowired
    PessoaJuridicaService service;

    @RequestMapping(method= RequestMethod.GET)
    public List<PessoaJuridica> getAll() {
        System.out.println("teste");
        System.out.println(service.getAll());
        ContaMatriz conta = ContaMatriz.builder()
            .id("00")
            .nome("getAll")
            .dataCriacao(new Date())
            .status(ContaMatriz.Status.ATIVA)
            .build();
        return asList(PessoaJuridica.builder()
            .cnpj("000")
            .nomeFantasia("fantasia")
            .razaoSocial("razao")
            .conta(conta)
            .build());
       //return service.getAll();
    }

    @RequestMapping(method= RequestMethod.POST)
    public void save(@RequestBody PessoaJuridica pessoaJuridica) {
        System.out.println(pessoaJuridica);
        service.save((PessoaJuridica) pessoaJuridica);
    }

    @RequestMapping(method= RequestMethod.PUT)
    public void update(@RequestBody PessoaJuridica pessoaJuridica) {
        System.out.println(pessoaJuridica);
        service.save((PessoaJuridica) pessoaJuridica);
    }

    @RequestMapping(value="/{id}", method= RequestMethod.GET)
    public PessoaJuridica getById(@PathVariable("id") String id) {

        System.out.println(id);
        return (PessoaJuridica) service.getById(id);
    }

    @RequestMapping(value="/{id}", method= RequestMethod.DELETE)
    public ResponseEntity delete(@PathVariable("id") String id) {

        System.out.println(id);
        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }
}
