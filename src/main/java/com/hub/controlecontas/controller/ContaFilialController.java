package com.hub.controlecontas.controller;

import com.hub.controlecontas.database.service.ContaFilialService;
import com.hub.controlecontas.model.ContaFilial;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value="/parent-filial")
public class ContaFilialController {

    @Autowired
    ContaFilialService service;

    @RequestMapping(method= RequestMethod.GET)
    public List<ContaFilial> getAll() {
       return service.getAll();

    }

    @RequestMapping(method= RequestMethod.POST)
    public ContaFilial save(@RequestBody ContaFilial contaFilial) {
        return service.save(contaFilial);
    }

    @RequestMapping(method= RequestMethod.PUT)
    public ContaFilial update(@RequestBody ContaFilial contaFilial) {
        return service.save(contaFilial);
    }

    @RequestMapping(value="/{id}", method= RequestMethod.GET)
    public ContaFilial getById(@PathVariable("id") String id) {
        return service.getById(id);
    }

    @RequestMapping(value="/{id}", method= RequestMethod.DELETE)
    public ResponseEntity delete(@PathVariable("id") String id) {

        service.delete(service.getById(id));

        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }
}
