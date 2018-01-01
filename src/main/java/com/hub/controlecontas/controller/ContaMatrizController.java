package com.hub.controlecontas.controller;

import com.hub.controlecontas.database.service.ContaMatrizService;
import com.hub.controlecontas.model.ContaMatriz;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value="/conta-matriz")
public class ContaMatrizController {

    @Autowired
    ContaMatrizService service;

    @RequestMapping(method= RequestMethod.GET)
    public List<ContaMatriz> getAll() {
       /* System.out.println("getAll");
        return asList(ContaMatriz.builder()
            .id("00")
            .nome("getAll")
            .dataCriacao(new Date())
            .status(ContaMatriz.Status.ATIVA)
            .build());*/
        return service.getAll();
    }

    @RequestMapping(method= RequestMethod.POST)
    public ContaMatriz save(@RequestBody ContaMatriz contaMatriz) {
        return service.save(contaMatriz);
    }

    @RequestMapping(method= RequestMethod.PUT)
    public ContaMatriz update(@RequestBody ContaMatriz contaMatriz) {
        return service.save(contaMatriz);
    }

    @RequestMapping(value="/{id}", method= RequestMethod.GET)
    public ContaMatriz getById(@PathVariable("id") String id) {
        return service.getById(id);
    }

    @RequestMapping(value="/{id}", method= RequestMethod.DELETE)
    public ResponseEntity delete(@PathVariable("id") String id) {

        service.delete(service.getById(id));

        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }
}
