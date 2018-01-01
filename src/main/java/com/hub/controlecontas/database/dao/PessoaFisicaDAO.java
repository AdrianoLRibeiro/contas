package com.hub.controlecontas.database.dao;

import com.hub.controlecontas.model.PessoaFisica;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PessoaFisicaDAO extends JpaRepository<PessoaFisica, String> {
}
