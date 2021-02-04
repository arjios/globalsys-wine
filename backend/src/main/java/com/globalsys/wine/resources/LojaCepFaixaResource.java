package com.globalsys.wine.resources;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.globalsys.wine.entities.LojaCepFaixa;

@RestController
@RequestMapping(value = "/lojacepfaixas")
public class LojaCepFaixaResource {
	
	@GetMapping
	public ResponseEntity<List<LojaCepFaixa>> findAll() {
		List<LojaCepFaixa> list = new ArrayList<>();
		list.add(new LojaCepFaixa(1L, "LOJA_PINHEIROS", 10000000L, 2000000L));
		list.add(new LojaCepFaixa(2L, "LOJA_PINHEIROS", 20000001L, 3000000L));
		list.add(new LojaCepFaixa(3L, "LOJA_JARDINS", 40000000L, 5000000L));
		list.add(new LojaCepFaixa(4L, "LOJA_JARDINS", 50000000L, 6000000L));
		list.add(new LojaCepFaixa(5L, "LOJA_MOEMA", 60000000L, 7000000L));
		return ResponseEntity.ok().body(list);
	}

}
