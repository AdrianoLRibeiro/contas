package com.hub.controlecontas.database.service;

import com.hub.controlecontas.database.dao.PessoaJuridicaDAO;
import com.hub.controlecontas.model.PessoaJuridica;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PessoaJuridicaService extends GenericService<PessoaJuridica, String, PessoaJuridicaDAO>{

    @Autowired
    public PessoaJuridicaService(PessoaJuridicaDAO dao) {
        super(dao);
    }

    /*@Autowired
    PessoaJuridicaDAO dao;

    public void save(PessoaJuridica pessoaJuridica) {
        dao.save(pessoaJuridica);
    }

    public List<PessoaJuridica> getAll() {
        return dao.findAll();
    }*/

}
