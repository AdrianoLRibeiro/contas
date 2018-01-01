package com.hub.controlecontas.controller;

import com.hub.controlecontas.database.service.PessoaFisicaService;
import com.hub.controlecontas.model.PessoaFisica;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value="/pessoa-fisica")
public class PessoaFisicaController {

    @Autowired
    PessoaFisicaService service;

    @RequestMapping(method= RequestMethod.GET)
    public List<PessoaFisica> getAll() {
        return service.getAll();
    }

    @RequestMapping(method= RequestMethod.POST)
    public PessoaFisica save(@RequestBody PessoaFisica pessoaFisica) {
        return service.save(pessoaFisica);
    }

    @RequestMapping(method= RequestMethod.PUT)
    public PessoaFisica update(@RequestBody PessoaFisica pessoaFisica) {
        return service.save(pessoaFisica);
    }

    @RequestMapping(value="/{id}", method= RequestMethod.GET)
    public PessoaFisica getById(@PathVariable("id") String id) {
        return service.getById(id);
    }

    @RequestMapping(value="/{id}", method= RequestMethod.DELETE)
    public ResponseEntity delete(@PathVariable("id") String id) {

        service.delete(service.getById(id));

        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }
}
