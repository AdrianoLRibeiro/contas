package com.hub.controlecontas.database.dao;

import com.hub.controlecontas.model.ContaMatriz;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ContaMatrizDAO extends JpaRepository<ContaMatriz, String> {
}
