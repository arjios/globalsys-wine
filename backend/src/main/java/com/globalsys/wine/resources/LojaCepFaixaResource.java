package com.globalsys.wine.resources;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.globalsys.wine.entities.LojaCepFaixa;
import com.globalsys.wine.services.LojaCepFaixaService;

@RestController
@RequestMapping(value = "/lojacepfaixas")
public class LojaCepFaixaResource {
	
	@Autowired
	private LojaCepFaixaService service;
	
	@GetMapping
	public ResponseEntity<List<LojaCepFaixa>> findAll() {
		List<LojaCepFaixa> list = service.findAll();
		return ResponseEntity.ok().body(list);
	}

}
