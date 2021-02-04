package com.globalsys.wine.entities;

import java.io.Serializable;



public class LojaCepFaixa implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private Long id;
	
	private String codigo_loja;
	private Long faixa_inicio;
	private Long faixa_fim;
	
	public LojaCepFaixa() {
	}

	public LojaCepFaixa(Long id, String codigo_loja, Long faixa_inicio, Long faixa_fim) {
		this.id = id;
		this.codigo_loja = codigo_loja;
		this.faixa_inicio = faixa_inicio;
		this.faixa_fim = faixa_fim;
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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		LojaCepFaixa other = (LojaCepFaixa) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

}
