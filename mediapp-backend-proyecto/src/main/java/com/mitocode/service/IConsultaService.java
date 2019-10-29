package com.mitocode.service;

import java.util.List;

import com.mitocode.model.Consulta;

public interface IConsultaService {

	Consulta registrar(Consulta consulta);

	void modificar(Consulta consulta);

	void eliminar(int idConsulta);

	Consulta listarId(int idConsulta);

	List<Consulta> listar();
}
