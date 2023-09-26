package br.com.mac0472.planejamentoorcamentario.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.mac0472.planejamentoorcamentario.entity.Income;

public interface IncomeRepository extends JpaRepository<Income, Long>{
	
}
