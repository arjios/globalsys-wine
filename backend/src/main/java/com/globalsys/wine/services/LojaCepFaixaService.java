package com.globalsys.wine.services;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.globalsys.wine.dto.LojaCepFaixaDTO;
import com.globalsys.wine.entities.LojaCepFaixa;
import com.globalsys.wine.repositories.LojaCepFaixaRepository;
import com.globalsys.wine.services.exceptions.ResourceNotFoundException;

@Service
public class LojaCepFaixaService {
	
	@Autowired
	private LojaCepFaixaRepository repository;
	
	@Transactional(readOnly = true)
	public List<LojaCepFaixaDTO> findAll() {
		List<LojaCepFaixa> list = repository.findAll();
		return list.stream().map(x -> new LojaCepFaixaDTO(x)).collect(Collectors.toList());
	}
	
	@Transactional(readOnly = true)
	public LojaCepFaixaDTO findById(Long id) {
		Optional<LojaCepFaixa> obj = repository.findById(id);
		LojaCepFaixa entity = obj.orElseThrow(() -> new ResourceNotFoundException("Entidade não encontrada"));
		return new LojaCepFaixaDTO(entity);
	}
	
}
