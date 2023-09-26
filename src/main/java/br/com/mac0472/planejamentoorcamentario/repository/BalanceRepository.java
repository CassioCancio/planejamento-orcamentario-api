package br.com.mac0472.planejamentoorcamentario.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.mac0472.planejamentoorcamentario.entity.Balance;

public interface BalanceRepository extends JpaRepository<Balance, Long>{
	
}
