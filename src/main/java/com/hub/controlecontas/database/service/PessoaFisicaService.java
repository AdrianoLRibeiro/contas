package com.hub.controlecontas.database.service;

import com.hub.controlecontas.database.dao.PessoaFisicaDAO;
import com.hub.controlecontas.model.PessoaFisica;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PessoaFisicaService extends GenericService<PessoaFisica, String, PessoaFisicaDAO>{

    @Autowired
    public PessoaFisicaService(PessoaFisicaDAO dao) {
        super(dao);
    }


    /*@Autowired
    PessoaFisicaDAO dao;

    public void save(PessoaFisica pessoaFisica) {
        dao.save(pessoaFisica);
    }

    public List<PessoaFisica> getAll() {
        return dao.findAll();
    }*/
}
