package com.hub.controlecontas.database.dao;

import com.hub.controlecontas.model.PessoaJuridica;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PessoaJuridicaDAO  extends JpaRepository<PessoaJuridica, String>{
}
