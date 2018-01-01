package com.hub.controlecontas.database.service;

import com.hub.controlecontas.database.dao.ContaFilialDAO;
import com.hub.controlecontas.model.ContaFilial;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ContaFilialService extends GenericService <ContaFilial, String, ContaFilialDAO>{

    @Autowired
    public ContaFilialService(ContaFilialDAO dao) {
        super(dao);
    }
}
