package com.hub.controlecontas.database.service;

import com.hub.controlecontas.database.dao.ContaMatrizDAO;
import com.hub.controlecontas.model.ContaMatriz;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ContaMatrizService extends GenericService<ContaMatriz, String, ContaMatrizDAO> {

    @Autowired
    public ContaMatrizService(ContaMatrizDAO dao) {
        super(dao);
    }
}
