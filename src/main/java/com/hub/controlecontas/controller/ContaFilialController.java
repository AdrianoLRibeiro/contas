package com.hub.controlecontas.controller;

import com.hub.controlecontas.database.service.ContaFilialService;
import com.hub.controlecontas.model.ContaFilial;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

import static java.util.Arrays.asList;

@RestController
@RequestMapping(value="/conta-filial")
public class ContaFilialController {

    @Autowired
    ContaFilialService service;

    @RequestMapping(method= RequestMethod.GET)
    public List<ContaFilial> getAll() {
        System.out.println("getAll");
        System.out.println(service.getAll());
        return asList(new ContaFilial("id", "nome", new Date(), ContaFilial.Status.ATIVA));

    }

    @RequestMapping(method= RequestMethod.POST)
    public void save(@RequestBody ContaFilial contaFilial) {
        System.out.println(contaFilial);
    }

    @RequestMapping(method= RequestMethod.PUT)
    public void update(@RequestBody ContaFilial contaFilial) {
        System.out.println(contaFilial);
    }

    @RequestMapping(value="/{id}", method= RequestMethod.GET)
    public ContaFilial getById(@PathVariable("id") String id) {

        System.out.println(id);
        return null;
    }

    @RequestMapping(value="/{id}", method= RequestMethod.DELETE)
    public ResponseEntity delete(@PathVariable("id") String id) {

        System.out.println(id);
        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }
}
