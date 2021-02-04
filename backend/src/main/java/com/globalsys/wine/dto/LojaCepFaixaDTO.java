package com.globalsys.wine.dto;

import java.io.Serializable;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.globalsys.wine.entities.LojaCepFaixa;

public class LojaCepFaixaDTO implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String codigo_loja;
	private Long faixa_inicio;
	private Long faixa_fim;
	
	public LojaCepFaixaDTO() {
	}

	public LojaCepFaixaDTO(Long id, String codigo_loja, Long faixa_inicio, Long faixa_fim) {
		this.id = id;
		this.codigo_loja = codigo_loja;
		this.faixa_inicio = faixa_inicio;
		this.faixa_fim = faixa_fim;
	}
	
	public LojaCepFaixaDTO(LojaCepFaixa entity) {
		this.id = entity.getId();
		this.codigo_loja = entity.getCodigo_loja();
		this.faixa_inicio = entity.getFaixa_inicio();
		this.faixa_fim = entity.getFaixa_fim();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCodigo_loja() {
		return codigo_loja;
	}

	public void setCodigo_loja(String codigo_loja) {
		this.codigo_loja = codigo_loja;
	}

	public Long getFaixa_inicio() {
		return faixa_inicio;
	}

	public void setFaixa_inicio(Long faixa_inicio) {
		this.faixa_inicio = faixa_inicio;
	}

	public Long getFaixa_fim() {
		return faixa_fim;
	}

	public void setFaixa_fim(Long faixa_fim) {
		this.faixa_fim = faixa_fim;
	}

}
