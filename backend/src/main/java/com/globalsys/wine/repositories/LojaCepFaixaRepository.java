package com.globalsys.wine.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.globalsys.wine.entities.LojaCepFaixa;

@Repository
public interface LojaCepFaixaRepository extends JpaRepository<LojaCepFaixa, Long>{

}
