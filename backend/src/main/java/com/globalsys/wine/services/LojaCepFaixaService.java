package com.globalsys.wine.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.globalsys.wine.entities.LojaCepFaixa;
import com.globalsys.wine.repositories.LojaCepFaixaRepository;

@Service
public class LojaCepFaixaService {
	
	@Autowired
	private LojaCepFaixaRepository repository;
	
	public List<LojaCepFaixa> findAll() {
		return repository.findAll();
	}
}
