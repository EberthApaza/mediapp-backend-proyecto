package com.mitocode.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mitocode.model.Consulta;
import com.mitocode.service.IConsultaService;

@RestController
@RequestMapping("/consultas")
public class ConsultaController {
	
	@Autowired
	private IConsultaService service;
	
	@GetMapping(value = "/listar", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Consulta>> listar() {
		List<Consulta> consultas = new ArrayList<>();
		try {
			consultas = service.listar();
		} catch (Exception e) {
			return new ResponseEntity<List<Consulta>>(consultas, HttpStatus.OK);
		}

		return new ResponseEntity<List<Consulta>>(consultas, HttpStatus.OK);
	}
	
	@PostMapping(value = "/registrar", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Consulta> registrar(@RequestBody Consulta consulta) {
		Consulta c = new Consulta();
		try {
			c = service.registrar(consulta);
		} catch (Exception e) {
			return new ResponseEntity<Consulta>(c, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return new ResponseEntity<Consulta>(c, HttpStatus.OK);
	}


}
