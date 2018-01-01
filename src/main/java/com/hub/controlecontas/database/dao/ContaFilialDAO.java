package com.hub.controlecontas.database.dao;

import com.hub.controlecontas.model.ContaFilial;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ContaFilialDAO extends JpaRepository<ContaFilial, String> {
}
