package com.mitocode.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mitocode.dao.IConsultaDAO;
import com.mitocode.model.Consulta;
import com.mitocode.service.IConsultaService;

@Service
public class ConsultaServiceImpl implements IConsultaService {

	@Autowired
	private IConsultaDAO dao;

	@Override
	public Consulta registrar(Consulta consulta) {		
		//Esto es java7
		/*for(DetalleConsulta det : consulta.getDetalleConsulta()) {
			det.setConsulta(consulta);
		}*/
		//java 8
		consulta.getDetalleConsulta().forEach(x -> x.setConsulta(consulta));		
		return dao.save(consulta);
	}

	@Override
	public void modificar(Consulta consulta) {
		dao.save(consulta);
	}

	@Override
	public void eliminar(int idConsulta) {
		dao.delete(idConsulta);
	}

	@Override
	public Consulta listarId(int idConsulta) {
		return dao.findOne(idConsulta);
	}

	@Override
	public List<Consulta> listar() {
		return dao.findAll();
	}

}
