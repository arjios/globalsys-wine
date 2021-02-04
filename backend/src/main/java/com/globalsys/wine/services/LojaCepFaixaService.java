package com.globalsys.wine.services;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.globalsys.wine.dto.LojaCepFaixaDTO;
import com.globalsys.wine.entities.LojaCepFaixa;
import com.globalsys.wine.repositories.LojaCepFaixaRepository;
import com.globalsys.wine.services.exceptions.FaixaCepException;
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
	public boolean testFaixaCepAll(Long faixa_inicio, Long faixa_fim) {
		boolean boo = false;
		List<LojaCepFaixa> list = repository.findAll();
		for(LojaCepFaixa cat : list) {
			if(faixa_inicio > faixa_fim) {
				Long aux = faixa_inicio;
				faixa_inicio = faixa_fim;
				faixa_fim = aux;				
			}
			if(faixa_inicio <= cat.getFaixa_inicio() && faixa_fim >= cat.getFaixa_fim()) {
				boo = true;
			}
			if(faixa_inicio >= cat.getFaixa_inicio() && faixa_inicio <= cat.getFaixa_fim()) {
				boo = true;
			}
		}
		return boo;
	}
	
	@Transactional(readOnly = true)
	public LojaCepFaixaDTO findById(Long id) {
		Optional<LojaCepFaixa> obj = repository.findById(id);
		LojaCepFaixa entity = obj.orElseThrow(() -> new ResourceNotFoundException("Entidade não encontrada"));
		return new LojaCepFaixaDTO(entity);
	}

	@Transactional
	public LojaCepFaixaDTO insert(LojaCepFaixaDTO dto) {
		LojaCepFaixa entity = new LojaCepFaixa();
		entity.setCodigo_loja(dto.getCodigo_loja());
		if(testFaixaCepAll(dto.getFaixa_inicio(), dto.getFaixa_fim())) {
			throw new FaixaCepException("Id not Found: ");
		}
		entity.setFaixa_inicio(dto.getFaixa_inicio());
		entity.setFaixa_fim(dto.getFaixa_fim());
		entity = repository.save(entity);
		return new LojaCepFaixaDTO(entity);
	}

	@Transactional
	public LojaCepFaixaDTO update(Long id, LojaCepFaixaDTO dto) {
		try {
			LojaCepFaixa entity = repository.getOne(id);
			entity.setCodigo_loja(dto.getCodigo_loja());
			entity.setFaixa_inicio(dto.getFaixa_inicio());
			entity.setFaixa_fim(dto.getFaixa_fim());
			if(testFaixaCepAll(dto.getFaixa_inicio(), dto.getFaixa_fim())) {
				throw new FaixaCepException("Erro: Faixa de CEP sobreposto!");
			}
			entity = repository.save(entity);
			return new LojaCepFaixaDTO(entity);
		} catch(EntityNotFoundException e) {
			throw new ResourceNotFoundException("Id not Found: " + id);
		} catch(FaixaCepException e) {
			throw new FaixaCepException("Erro: Faixa de CEP sobreposto!");
		}
	}

	public void delete(Long id) {
		try {
			repository.deleteById(id);
		}
		catch(EmptyResultDataAccessException e) {
			throw new ResourceNotFoundException("Id not Found: " + id);
		}
		
	}
}
