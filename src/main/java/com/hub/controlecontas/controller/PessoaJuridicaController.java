package com.hub.controlecontas.controller;

import com.hub.controlecontas.database.service.PessoaJuridicaService;
import com.hub.controlecontas.model.ContaMatriz;
import com.hub.controlecontas.model.PessoaJuridica;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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
        /*System.out.println("teste");
        System.out.println(service.getAll());
        ContaMatriz parent = ContaMatriz.builder()
            .id("00")
            .nome("getAll")
            .dataCriacao(new Date())
            .status(ContaMatriz.Status.ATIVA)
            .build();
        return asList(PessoaJuridica.builder()
            .cnpj("000")
            .nomeFantasia("fantasia")
            .razaoSocial("razao")
            .parent(parent)
            .build());*/
       return service.getAll();
    }

    @RequestMapping(method= RequestMethod.POST)
    public PessoaJuridica save(@RequestBody PessoaJuridica pessoaJuridica) {
        return service.save(pessoaJuridica);
    }

    @RequestMapping(method= RequestMethod.PUT)
    public PessoaJuridica update(@RequestBody PessoaJuridica pessoaJuridica) {
        return service.save(pessoaJuridica);
    }

    @RequestMapping(value="/{id}", method= RequestMethod.GET)
    public PessoaJuridica getById(@PathVariable("id") String id) {
        return service.getById(id);
    }

    @RequestMapping(value="/{id}", method= RequestMethod.DELETE)
    public ResponseEntity delete(@PathVariable("id") String id) {

        service.delete(service.getById(id));

        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }
}
