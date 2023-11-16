package br.com.mac0472.planejamentoorcamentario.repository;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.mac0472.planejamentoorcamentario.entity.Balance;
import br.com.mac0472.planejamentoorcamentario.entity.Expense;

public interface ExpenseRepository extends JpaRepository<Expense, Long> {
	
	List<Expense> findByBalance(Balance balanco);
	
	
}
