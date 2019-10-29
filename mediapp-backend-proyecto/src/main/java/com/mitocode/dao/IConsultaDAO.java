package com.mitocode.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mitocode.model.Consulta;

@Repository
public interface IConsultaDAO extends JpaRepository<Consulta, Integer>{

}
